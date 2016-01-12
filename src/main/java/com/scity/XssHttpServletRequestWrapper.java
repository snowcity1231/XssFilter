package com.scity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Description: 
 * <p>
 * Copyright: Copyright(C) 2014 公司 Inc. All Rights Reserved.  
 * <p>
 *  Department: zhfzm 平台开发组  
 * <p>
 * @Author xuechen
 * <p>
 * @Version 2.0.0  2016-1-12 下午2:41:03
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if(values == null) {
			return null;
		}
		int count = values.length;
		String[] encodeValues = new String[count];
		for(int i=0; i < count; i++){
			encodeValues[i] = cleanXss(values[i]);
		}
		return encodeValues;
	}
	
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(null == value) {
			return null;
		}
		return cleanXss(value);
	}
	
	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		if(null == value) {
			return null;
		}
		return cleanXss(value);
	}


	private String cleanXss(String value) {
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");  
        value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");  
        value = value.replaceAll("'", "& #39;");  
        value = value.replaceAll("eval\\((.*)\\)", "");  
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");  
        value = value.replaceAll("script", "");  
		return value;
	}

}
