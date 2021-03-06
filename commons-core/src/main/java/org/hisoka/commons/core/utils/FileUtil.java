package org.hisoka.commons.core.utils;

import java.io.File;

/**
 * 文件操作工具类
 *
 * @author Hinsteny
 * @version FileUtil: FileUtil 2019-05-10 10:17 All rights reserved.$
 */
public class FileUtil {

    /**
     * 判断路径所指文件是否存在
     */
    public static boolean isFileExists(String filePath) {
        if (StringUtil.isBlank(filePath)) {
            return false;
        }
        File file = new File(filePath);
        return file.exists();
    }

    /**
     * 获取文件名称
     */
    public static String getFileName(String filePath) {
        if (!isFileExists(filePath)) {
            return null;
        }
        File file = new File(filePath);
        return file.getName();
    }

    /**
     * 获取文件大小
     */
    public static long getFileSize(String filePath) {
        if (!isFileExists(filePath)) {
            return -1;
        }
        File file = new File(filePath);
        return file.length();
    }

    /**
     * 删除路径
     * @param filePath
     * @return
     */
    public static boolean delete(String filePath) {
        if (!isFileExists(filePath)) {
            return false;
        }
        File file = new File(filePath);

        if (file.isFile()) {
            return deleteFile(file);
        } else {
            return deleteDirectory(file);
        }
    }

    /**
     * 删除文件
     * @param file
     * @return
     */
    private static boolean deleteFile(File file) {
        if (file.exists()) {
            file.delete();
        }
        return true;
    }

    /**
     * 递归删除文件目录
     * @param dirFile
     * @return
     */
    private static boolean deleteDirectory(File dirFile) {
        if (dirFile.exists()) {
            File[] files = dirFile.listFiles();

            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    deleteFile(files[i]);
                } else {
                    deleteDirectory(files[i]);
                }
            }
        }
        dirFile.delete();
        return true;
    }

}
