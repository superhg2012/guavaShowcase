package org.netease.test.collections;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableMap;

public class TestImmutableMap {

	private static final Map<String, Integer> map = ImmutableMap.<String, Integer> builder().put("1", 1).put("2", 2)
			.build();

	public static String getKey(Map<String, Integer> map, int value) {

		Set<Entry<String, Integer>> set = map.entrySet();
		if (CollectionUtils.isNotEmpty(set)) {
			for (Entry<String, Integer> entry : set) {
				if (entry.getValue() == value) {
					return entry.getKey();
				}
			}
		}
		return StringUtils.EMPTY;
	}

	public static void main(String[] args) {
		String ret = getKey(map, 2);
		System.out.println(ret);
	}
}
