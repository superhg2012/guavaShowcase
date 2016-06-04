package org.netease.test.fileprocess;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.collect.Maps;

public class TestBigData {

	private static final String RETPATH = "D:/work/usercenter/intersection/";
	private static final String path1 = "D:\\work\\usercenter\\userdata\\1\\";
	private static final String path2 = "D:\\work\\usercenter\\userdata-online\\";
	private static final String MERGEDFILEPATH = "D:/work/usercenter/summary.txt";

	public static void main(String[] args) {


		Map<String, File> onlineMap = Maps.newHashMap();
		Map<String, File> ursMap = Maps.newHashMap();

		File ursFile = new File(path1);

		if (ursFile.isDirectory()) {
			File[] files = ursFile.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if (file.isDirectory()) {
					File[] subfiles = file.listFiles();
					for (File F : subfiles) {
						ursMap.put(F.getName(), F);
					}
				} else {
					ursMap.put(file.getName(), file);
				}

			}
		}

		File onlineFile = new File(path2);

		if (onlineFile.isDirectory()) {
			File[] files = onlineFile.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				onlineMap.put(file.getName(), file);
			}
		}

		System.out.println(ursMap.toString());
		System.out.println(onlineMap.toString());

		//step2 : coumpte intersections
		//computeInterSection(ursMap, onlineMap);
		
		
		//step last: merge files
		
		MergeFileUtil.mergeFile(RETPATH, MERGEDFILEPATH);
	}

	public static void computeInterSection(Map<String, File> mapurs, Map<String, File> maponline) {

		final String postFix = ".txt";

		List<String> list = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
				"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
				"other");

		ExecutorService eService = Executors.newFixedThreadPool(36);
		final String key = "1";
		for (int i = 0; i < list.size(); i++) {
			File ursFile = mapurs.get(key + list.get(i) + postFix);
			File onlineFile = maponline.get(key + postFix);
			eService.execute(new ComputeThread(ursFile.getAbsolutePath(), onlineFile.getAbsolutePath(),
					RETPATH + key + list.get(i) + postFix));
		}
		
		eService.shutdown();

	}

}
