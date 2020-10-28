package com.example.vedioapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;

import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {
    public static final String FILE_NAME = "data.txt";

    //保存账号密码到data.txt文件
    public static boolean saveAccount(Context context,String account,String password){
        try (FileOutputStream fos = context.openFileOutput(FILE_NAME,Context.MODE_PRIVATE)){
//            fos.write((account + ","+ password).getBytes());
//            fos.flush();
//            fos.close();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(account+","+password);
            writer.flush();
            writer.close();
            return true;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    //保存到外部存储
    public static boolean savePublic(Context context,String account,String password){
        // 1.检查写SD卡的权限
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions((Activity)context,
                        new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        },1);
                return false;
            }
        }
        // 2.Android 10.0以下版本的外部存储的处理
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){
            // 获取SD卡的根目录
            File SDPath = Environment.getExternalStorageDirectory();
            File file = new File(SDPath,FILE_NAME);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write((account + ","+password).getBytes());
                fos.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    // 从外部存储获取
    public static Map<String,String> getPublic(Context context){
        Map<String,String> content = new HashMap<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions((Activity)context,new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE
                },2);
                return content;
            }
        }
        // Android 10.0以下版本的外部存储的处理
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)){
            //获取SD卡路径
            File SDPath = Environment.getExternalStorageDirectory();
            //创建文件对象
            File file = new File(SDPath,FILE_NAME);
            try{
                //创建文件输入流对象
                FileInputStream fis = new FileInputStream(file);
                //创建输入缓冲流的对象
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                //读取数据
                String data = br.readLine();
                String[] infos = data.split(",");
                if (infos.length>0){
                    content.put("account",infos[0]);
                    content.put("password",infos[1]);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return content;
    }


    public static Map<String,String> getAccount(Context context){
        Map<String,String> content = new HashMap<>();
        try{
            FileInputStream fis = context.openFileInput(FILE_NAME);
//            byte[] buffer = new byte[fis.available()];
//            fis.read(buffer);
//            String[] infos = new String(buffer).split(",");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String[] infos = reader.readLine().split(",");
            if (infos.length>0){
                content.put("account",infos[0]);
                content.put("password",infos[1]);
            }
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return content;
    }

    public static void clear(Context context){
        File file = new File(context.getFilesDir(),FILE_NAME);
        if (file.exists()){
            file.delete();
        }
    }

    public static void clearPublic(Context context){
        File SDFile = Environment.getExternalStorageDirectory();
        File file = new File(SDFile,FILE_NAME);
        if (file.exists()){
            file.delete();
        }
    }
}
