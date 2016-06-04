package org.netease.test.collections;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class TestSets {

	public static void main(String[] args) {
		Set<String> setA = Sets.newHashSet();
		setA.add("dfdfd");
		setA.add("aaa");
		setA.add("bbb");
		setA.add("dfdcccfd");
		
		Set<String> setB = Sets.newHashSet();
		
		setB.add("dfdcccfd");
		setB.add("aaa");
		setB.add("ddd");
		setB.add("cc");
		
		SetView<String> ret = Sets.intersection(setA, setB);
		Iterator<String> iterator = setA.iterator();
		
		while(iterator.hasNext()){
			String key = iterator.next();
			if (setB.contains(key)) {
				System.out.println(key);
			}
		}
		
		System.out.println(ret.toString());
		
	}
}
