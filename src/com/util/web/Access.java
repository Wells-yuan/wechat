package com.util.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.ProtocolException;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.core.model.AccessToken;

public class Access {
//	private static final String APPID = "wx88241c5810d5280c";
//	private static final String APPSECRET = "d3882e7c217e7f5050b40f3270d2dc6a";
	private static final String APPID = "wx530b22caae0335cc";
	private static final String APPSECRET = "9ec05735cfbbbdb5ca6804ac57aea9a8";
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	private static final String filePath = "." + File.separator+"accessToken.txt";
	
	private static long pastTime = Long.parseLong("0");
//	private static long pastTime = Long.parseLong("1457082071113");
	
//	private final String filePath =getClass().getClassLoader().getResource("cfg"+File.separator+"accessToken.txt").getPath();
	/**
	 * get请求
	 * @param url
	 * @return
	 */
	public static JSONObject doGetStr(String url){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if(entity != null){
				String result = EntityUtils.toString(entity, "UTF-8");
				jsonObject = new JSONObject(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonObject;
	}
	
	/**
	 * post请求
	 * @param url
	 * @param outStr
	 * @return
	 */
	public static JSONObject doPostStr(String url, String outStr){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpPost.setEntity(new StringEntity(outStr, "UTF-8"));
		try {
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if(entity != null){
				String result = EntityUtils.toString(entity, "UTF-8");
				jsonObject = new JSONObject(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonObject;
	}
	
	/**
	 * 从微信服务器获取access_token
	 * @return
	 * @throws IOException 
	 */
	
	public static AccessToken fetchAccessToken() throws IOException{
		AccessToken token = new AccessToken();
		File file = new File(filePath);
		//System.out.println(file.getCanonicalPath());
		if(!file.exists()){
			file.createNewFile();
		}
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		if(jsonObject != null){
			token.setToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		
		FileOutputStream fos = new FileOutputStream(file, false);
		OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(out);
		bw.write(jsonObject.toString());
		
		bw.flush();
		bw.close();
		out.close();
		fos.close();
		
		pastTime = new Date().getTime();
		
		return token;
	}
	
	/**
	 * 从本地获取AccessToken
	 * @return
	 * @throws Exception
	 */
	public static String getAccessToken() throws Exception{
		AccessToken token = new AccessToken();
		File file = new File(filePath);
		Reader reader;
		if(file.exists()){
			long currTime = new Date().getTime();
			System.out.println("currTime: "+currTime);
			System.out.println("pastTime: "+pastTime);
			
			if((currTime - pastTime)/1000 < 7200){
				char[] buf = new char[(int)file.length()];
				reader = new FileReader(file);
				reader.read(buf);
				reader.close();
				JSONObject jsonObject = new JSONObject(new String(buf));
				if(jsonObject != null){
					token.setToken(jsonObject.getString("access_token"));
					token.setExpiresIn(jsonObject.getInt("expires_in"));
				}
			}else{
				return fetchAccessToken().getToken();
			}
		}else{
			token = fetchAccessToken();
		}
		//System.out.println(token.getToken());
		return token.getToken();
	}
	
	
	/**
	 * 上传文件
	 * @param filePath
	 * @param accessToken
	 * @param type
	 * @return
	 * @throws ProtocolException
	 * @throws IOException
	 */
	public static String upload(String filePath, String accessToken, String type) throws ProtocolException, IOException {
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
		HttpPost httpPost = new HttpPost(url);
		
		httpPost.setHeader("Connection", "Keep-Alive");
		httpPost.setHeader("Cache-Control", "no-cache");
		File bin = new File(filePath);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();   
//		MultipartEntity reqEntity = new MultipartEntity();
		builder.addBinaryBody("file", bin, ContentType.DEFAULT_BINARY, bin.getName());
		HttpEntity reqEntity = builder.build();
		httpPost.setEntity(reqEntity);
		
		HttpResponse response = httpClient.execute(httpPost);
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode == HttpStatus.SC_OK){
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
		}
		
		httpClient.close();
		
		return result;
		
		/*File file = new File(filePath);
		if(!file.exists() || !file.isFile()){
			throw new IOException("文件不存在！");
		}
		
		String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
		
		URL urlObj = new URL(url);
		//连接
		HttpURLConnection con = (HttpURLConnection)urlObj.openConnection();
		
		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);
		
		//设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
		
		//设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data;boundary="+BOUNDARY);;
		
		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition:form-data;name=\"file\";filename=\""+file.getName()+"\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		
		byte[] head = sb.toString().getBytes("UTF-8");
		
		//获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		//输出表头
		out.write(head);
		
		//文件正文部分
		//把文件以流文件的方式推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1){
			out.write(bufferOut, 0, bytes);
		}
		in.close();
		
		//结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");//定义最后的数据分隔线
		
		out.write(foot);
		
		out.flush();
		out.close();
		
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try{
			//定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while((line = reader.readLine()) != null){
				buffer.append(line);
			}
			if(result == null){
				result = buffer.toString();
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(reader != null){
				reader.close();
			}
		}
		
		return result;*/
	}
	
	
	/**
	 * 获取media_id
	 * @param filePath
	 * @param accessToken
	 * @param type
	 * @return
	 * @throws ProtocolException
	 * @throws IOException
	 */
	public static String getMediaId(String filePath, String accessToken, String type) throws ProtocolException, IOException{
		String mediaId = null;
		String typeNme = "media_id";
		String result = upload(filePath, accessToken, type);
		JSONObject jsonObject = new JSONObject(result);
		//System.out.println(jsonObject);
		if(!"image".equals(type)){
			typeNme = type + "_media_id";
		}
		if(jsonObject.has(typeNme)){
			mediaId = jsonObject.getString(typeNme);
		}
		return mediaId;
	}
	
	
	
	public static void main(String[] args) throws Exception {
//		AccessToken token = Access.getAccessToken();
//		System.out.println("票据: "+ token.getToken());
//		System.out.println("有效时间: "+ token.getExpiresIn());
	}
}
