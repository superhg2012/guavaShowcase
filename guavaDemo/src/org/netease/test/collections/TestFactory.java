package org.netease.test.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class TestFactory {

	public static void main(String[] args) {
		Map<String, Object> map = Maps.newHashMapWithExpectedSize(2);

		map.put("errorCode", 0);

		map.put("key", true);

		map.put("url", "ddd");

		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			System.out.println(object.toString());
		}

	}
}
