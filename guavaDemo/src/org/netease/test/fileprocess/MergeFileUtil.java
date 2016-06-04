package org.netease.test.fileprocess;

import java.io.File;
import java.util.Set;

import org.netease.test.utils.FileUtils;

public class MergeFileUtil {

	public static void mergeFile(String targetFilePath, String mergeToFilePath) {
		File targetFile = new File(targetFilePath);

		if (targetFile.isDirectory()) {
			System.out.println("ddfdfd");
			File[] files = targetFile.listFiles();
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				System.out.println(file.getAbsolutePath());
				Set<String> setRet = FileUtils.readToSet2(file.getAbsolutePath());
				FileUtils.writeToFile2(setRet, mergeToFilePath, true);
			}
		}
		
		System.out.println(targetFile.getAbsolutePath() + "--");

	}
}
