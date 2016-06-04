package org.netease.test.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 
 * @author bjhegang
 *
 */
public class TestCache {

	private static final Cache<String, String> TEST_CACHE = CacheBuilder.newBuilder()
			.expireAfterWrite(10, TimeUnit.SECONDS).maximumSize(1000).build();

	public static void main(String[] args) {
		try {
			TEST_CACHE.get("key", new Callable<String>() {

				@Override
				public String call() throws Exception {
					return "ok";
				}
			});
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.exit(0);
		return;
	}

}
