package edu.spring.sample.example.rabbitmq.model;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * <code></code> is abstract class to override to string to display fields
 * @author SUMANPattanaik
 *
 */
public abstract class AbstractVO {
	@Override
	public String toString() {
		StringBuffer sb =  new StringBuffer(this.getClass().getSimpleName());
		Field[] fields = this.getClass().getDeclaredFields();
		sb.append("[");
		for(Field field : fields) {		
			try {
				field.setAccessible(true);
				sb.append(displayParamNameValue(field.getName(),getFieldValue(field.get(this))));
			} catch (Exception e) {
			}//EndTryCatch
		}//EndFor
		
		if(sb.toString().endsWith(","))
			sb.deleteCharAt(sb.length()-1);
		
		sb.append("]");
		return sb.toString();
	}// EndMethod
	
	/**
	 * 
	 * @param fieldValue
	 * @return
	 */
	protected String getFieldValue(Object fieldValue) {
		String value = (String) fieldValue;
		
		if(fieldValue instanceof String) {
			value =(String) fieldValue;
		}else if(fieldValue instanceof Map) {
			value =((Map) fieldValue).toString();
		}else if(fieldValue instanceof Set) {
			value =((Set) fieldValue).toString();
		}else if(fieldValue instanceof List) {
			value =((List) fieldValue).toString();
		}else if(fieldValue instanceof Integer) {
			value =  String.valueOf((Integer)fieldValue);
		}else if(fieldValue instanceof Double) {
			value =  String.valueOf((Double)fieldValue);
		}else if(fieldValue instanceof Long) {
			value =  String.valueOf((Long)fieldValue);
		}//EndIf
		return value;
	}//EndMethod
	
	/**
	 * 
	 * @param paramName
	 * @param paramValue
	 * @return
	 */
	protected String displayParamNameValue(String paramName, String paramValue) {
		StringBuffer sb = new StringBuffer();		
		if(paramValue!=null && !paramValue.equals("")) 
			sb.append("<").append(paramName).append("=").append(paramValue).append(">").append(",");		
		return sb.toString();	
	}//EndMethod
}//EndClass
