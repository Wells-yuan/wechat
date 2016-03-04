package com.wechat.admin.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.core.action.BaseAction;
import com.core.model.Message;
import com.util.check.MsgCheck;
import com.util.message.MessageUtil;
import com.util.message.MsgConvert;
import com.wechat.BaseConst;

@Controller
public class Development extends BaseAction {

	private static final long serialVersionUID = 4935083835977452627L;
	
	@ResponseBody
	@RequestMapping(value="/develop",method = RequestMethod.GET)
	public String DeveloperDigset(String signature, String timestamp, 
			String nonce, String echostr, HttpServletResponse response) throws IOException{
		if(MsgCheck.checkSignature(signature, timestamp, nonce)){
			return echostr;
		}
		return null;
	}

	@RequestMapping(value="/develop",method = RequestMethod.POST)
	public ModelAndView DeveloperProcess() throws IOException{
		ModelAndView mav = new ModelAndView("xmlViewer");
		Message text = null;
		try {
			Map<String, String> map = MsgConvert.xmlToMap(getRequest());
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			if("text".equals(msgType)){
				if("1".equals(content)){
					text = MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}else if("2".equals(content)){
					text = MessageUtil.initText(toUserName, fromUserName, MessageUtil.secondMenu());
				}else if("4".equals(content)){
					text = MessageUtil.initNewsMessage(toUserName, fromUserName);
				}else if("5".equals(content)){
					text = MessageUtil.initImageMessage(toUserName, fromUserName);
				}else if("6".equals(content)){
					text = MessageUtil.initMusicMessage(toUserName, fromUserName);
				}else if("?".equals(content) || "？".equals(content)){
					text = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else{
					text = MessageUtil.initText(toUserName, fromUserName, "你说"+content+"啊，我说"+content+"~~~");
				}
			}else if(BaseConst.MESSAGE_EVENT.equals(msgType)){
				String eventType = map.get("Event");
				if(BaseConst.MESSAGE_SUBSCRIBE.equals(eventType)){
					text = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if(BaseConst.MESSAGE_CLICK.equals(eventType)){
					text = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if(BaseConst.MESSAGE_VIEW.equals(eventType)){
					String url = map.get("EventKey");
					text = MessageUtil.initText(toUserName, fromUserName, url);
				}else if(BaseConst.MESSAGE_SCANCODE.equals(eventType)){
					String key = map.get("EventKey");
					text = MessageUtil.initText(toUserName, fromUserName, key);
				}
			}else if(BaseConst.MESSAGE_LOCATION.equals(msgType)){
				String label = map.get("Label");
				text = MessageUtil.initText(toUserName, fromUserName, label);
			}
			mav.addObject(text);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView XMLTest() throws IOException {
		com.core.model.Message msg = null;
		ModelAndView mav = new ModelAndView("xmlViewer");
//		TextMessage text = null;
//		String fromUserName = "123";
//		String toUserName = "abc";
//		String msgType = "text";
//		String content = "hahaha";
//
//		if (BaseConst.MESSAGE_TEXT.equals(msgType)) {
//			text = new TextMessage();
//			text.setFromUserName(toUserName);
//			text.setToUserName(fromUserName);
//			text.setMsgType("text");
//			text.setCreateTime(new Date().getTime());
//			text.setContent("您发送的消息是: " + content);
//			msg = text;
//			mav.addObject(msg);
//		}
		//msg = MessageUtil.initNewsMessage("123", "abc");
//		msg = MessageUtil.initImageMessage("123", "abc");
		msg = MessageUtil.initMusicMessage("123", "abc");
		mav.addObject(msg);
		return mav;
	}
	
	@RequestMapping(value="/index")
	public String Index( ){
		return "index";
	}

}
