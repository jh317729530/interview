package com.leihou.interview.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {

    /**
	 * 把对象转换成json
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	
	/**
	 * 转换成对象
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> classOfT) {
		Gson gson = new Gson();
		return gson.fromJson(json, classOfT);
	}


	public static String toJson(Object object, String dateFormat) {
		Gson gson = new GsonBuilder()
				.setDateFormat(dateFormat)
				.create();
		return gson.toJson(object);
	}



	/**
	 * 格式化json
	 * @param jsonString
	 * @return
	 */
	public static String toPrettyFormat(String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonString).getAsJsonObject();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = gson.toJson(json);

		return prettyJson;
	}





}