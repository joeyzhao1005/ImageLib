package com.kit.imagelib.uitls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.kit.imagelib.R;
import com.kit.imagelib.entity.ImageLibRequestResultCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

/**
 * @author wanggang
 */
public class ImageLibUitls {

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static boolean isEmptyOrNullOrNullStr(String str) {
        return str == null || TextUtils.isEmpty(str) || str.equals("null");
    }


    public static boolean isGif(String filedir) {
        if (isEmptyOrNullOrNullStr(filedir)) {
            return false;
        } else {
            String sub = getSuffix(filedir);
            boolean isGifPic = ("gif".equals(sub) || "GIF".equals(sub));
            return isGifPic;
        }
    }


    /**
     * 获取文件后缀，不带“.”
     *
     * @return
     */
    public static String getSuffix(File file) {
        String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        return suffix;
    }


    /**
     * 获取文件后缀，不带“.”
     *
     * @param filedir
     * @return
     */
    public static String getSuffix(String filedir) {
        if (isEmptyOrNullOrNullStr(filedir)) {
            return null;
        } else {
            String suffix = filedir.substring(filedir.lastIndexOf(".") + 1);
//            Zog.e(ImageLibUitls.class, "suffix:" + suffix);
            return suffix;
        }
    }

    /**
     * 删除文件
     *
     * @param file
     */
    public static void deleteFile(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        } else if (file.isDirectory()) {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0) {
                file.delete();
                return;
            }
            for (File f : childFile) {
                deleteFile(f);
            }
            file.delete();
        }
    }

    /**
     * 文件copy
     *
     * @param oldFilePath
     * @param newFilePath
     * @param cover       新目录存在，是否覆盖
     */
    public static String copy(String oldFilePath, String newFilePath, boolean cover) {


        if (!oldFilePath.equals(newFilePath)) {
            File oldfile = new File(oldFilePath);
            File newfile = new File(newFilePath);

            beforeSave(newFilePath);

            if (newfile.exists()) {//若在待转移目录下，已经存在待转移文件
                if (cover)//覆盖
                    oldfile.renameTo(newfile);
                else
                    Log.e("APP", "在新目录下已经存在：" + newFilePath);
            } else {
                oldfile.renameTo(newfile);
            }

            return newFilePath;
        }
        return null;
    }


    /**
     * 复制单个文件
     *
     * @param oldPath String 原文件路径 如：c:/fqf.txt
     * @param newPath String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }

    }


    public static File saveBitmap(Bitmap bmp, File file) throws IOException {
        if (bmp == null) {
            return null;
        } else {
            System.out.println("file.getPath():" + file.getPath());
            if ((new File(file.getParent())).mkdirs()) {
                System.out.println("建立目录成功");
            } else {
                System.out.println("建立目录失败");
            }

            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream(file);
                if (fos != null) {
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    fos.flush();
                    fos.close();
                }
            } catch (FileNotFoundException var4) {
                var4.printStackTrace();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            return file;
        }
    }


    private static void beforeSave(String fileName) {
        String dir = fileName.substring(0, fileName.lastIndexOf("/"));
        File directory = new File(dir);

        if (!directory.exists()) {
            directory.mkdir();//没有目录先创建目录
        }
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
