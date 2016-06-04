package org.netease.test.fileprocess;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;

import org.netease.test.utils.FileUtils;

import com.google.common.collect.Sets;


/**
 * 计算交集线程
 * 
 * @author bjhegang
 *
 */
public class ComputeThread implements Runnable {

    private String ursFilePath;
    private String onlineFilePath;
    private String targetFilePath;


    public ComputeThread(String ursFilePath, String onlineFilePath, String targetFilePath) {
        this.ursFilePath = ursFilePath;
        this.onlineFilePath = onlineFilePath;
        this.targetFilePath = targetFilePath;
    }


    @Override
    public void run() {
//        Set<String> setRet = Sets.intersection(FileUtils.readToSet(ursFilePath),
//                FileUtils.readToSet(onlineFilePath));
        
        Set<String> setA = FileUtils.readToSet(ursFilePath);
        Set<String> setB = FileUtils.readToSet(onlineFilePath);
        
        Set<String> intersection = Sets.newHashSet();
        Iterator<String> iterator = setA.iterator();
        while(iterator.hasNext()) {
            String target = iterator.next();
            if (setB.contains(target)) {
                intersection.add(target);
            }
        }
        
        System.out.println(Thread.currentThread().getName() + "--" + ursFilePath + "||" + onlineFilePath);
        if (intersection.isEmpty()) {
            System.out.println("无交集");
        } else {
            System.out.println(intersection.toString());
        }
        writeToFile(intersection, targetFilePath);
//        FileUtils.writeToFile(intersection, targetFilePath);
    }
    
    private synchronized void writeToFile(Set<String> setRet, String path) {

        try (BufferedWriter bWriter =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
            if (!setRet.isEmpty()) {
                Iterator<String> iterator = setRet.iterator();
                long count = 0;
                while (iterator.hasNext()) {
                    count++;
                    String string = iterator.next();
                    bWriter.write(string);
                    bWriter.newLine();
                    if (count % 1000 == 0) {
                        bWriter.flush();
                    }
                }
                bWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
