package com.util.menu;

import org.json.JSONObject;

import com.util.web.Access;
import com.wechat.admin.entity.BaseButton;
import com.wechat.admin.entity.ClickButton;
import com.wechat.admin.entity.Menu;
import com.wechat.admin.entity.ViewButton;

public class MenuUtil {
	
	private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	/**
	 * 初始化menu
	 * @return
	 */
	public static Menu initMenu(){
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");
		
		ViewButton button21 = new ViewButton();
		button21.setName("view菜单");
		button21.setType("view");
		button21.setUrl("http://www.ppj.gift");
		
		ClickButton button31 = new ClickButton();
		button31.setName("扫码事件");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		ClickButton button32 = new ClickButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");
		
		BaseButton button = new BaseButton();
		button.setName("菜单");
		button.setSub_button(new BaseButton[]{button31, button32});
		
		menu.setButton(new BaseButton[]{button11, button21, button});
		
		return menu;
	}
	
	/**
	 * 创建菜单
	 * @param token
	 * @param menu
	 * @return
	 */
	public static int CreateMenu(String token, String menu){
		int result = 0;
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = Access.doPostStr(url, menu);
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
	/**
	 * 查询菜单
	 * @param token
	 * @return
	 */
	public static JSONObject queryMenu(String token){
		String url = QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = Access.doGetStr(url);
		return jsonObject;
	}

	/**
	 * 删除菜单
	 * @param token
	 * @return
	 */
	public static int deleteMenu(String token){
		String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = Access.doGetStr(url);
		int result = 0;
		if(jsonObject.has("errcode")){
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		String menu = new JSONObject(MenuUtil.initMenu()).toString();
		int result = MenuUtil.CreateMenu(Access.getAccessToken(), menu);
		if(result == 0){
			System.out.println("菜单创建成功！");
		}else{
			System.out.println("菜单创建失败！");
		}
	}
}
