package org.netease.test.utils;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;

public class FileUtils {


    public static synchronized Set<String> readToSet(String path) {
        Set<String> set = Sets.newHashSet();

        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
        	System.out.println("ddddddddddd");
            return set;
        }

        try (BufferedReader bReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line = null;

            while ((line = bReader.readLine()) != null) {
                set.add(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return set;

    }
    
    
    
    
    public static synchronized Set<String> readToSet(File file) {
        Set<String> set = Sets.newHashSet();


        if (!file.exists() || !file.isFile()) {
        	System.out.println("ddddddddddd");
            return set;
        }

        try (BufferedReader bReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line = null;

            while ((line = bReader.readLine()) != null) {
                set.add(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return set;
    }
    
    
    
    public static Set<String> readToSet2 (String filepath) {
        Set<String> set = Sets.newHashSet();
        File file = new File(filepath);

        if (!file.exists() || !file.isFile()) {
        	System.out.println("ddddddddddd");
            return set;
        }

        try (BufferedReader bReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line = null;

            while ((line = bReader.readLine()) != null) {
                set.add(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return set;
    }
    

    public static synchronized void writeToFile(Set<String> setRet, String path, boolean append) {

        try (BufferedWriter bWriter =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, append), "UTF-8"))) {
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

    
    public static void writeToFile2(Set<String> setRet, String path, boolean append) {

        try (BufferedWriter bWriter =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, append), "UTF-8"))) {
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
