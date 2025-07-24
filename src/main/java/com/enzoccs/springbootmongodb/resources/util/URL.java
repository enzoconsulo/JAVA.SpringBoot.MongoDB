package com.enzoccs.springbootmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
	public static String decodeFromUrl(String search) {
		try {
			return URLDecoder.decode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
