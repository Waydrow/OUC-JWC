package com.waydrow.campusbox;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by slomo on 2016/3/23.
 */
public class getData {
    public static String getHtml (String path, String cookie, String num) {
        String msg = "";
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            String data = "xn=2015&xn1=2016&xq=1&ysyx=yscj&sjxz=sjxz1&userCode="+num+"&ysyxS=on&sjxzS=on";

            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Trident/7.0; MSIE 8; rv:11.0) like Gecko");
            conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            conn.setRequestProperty("Accept-Encoding","gzip, deflate");
            conn.setRequestProperty("Referer","http://jwgl.ouc.edu.cn/student/xscj.stuckcj.jsp?menucode=JW130705");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("Cookie",cookie);

            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(data.getBytes());
            outputStream.flush();

            if(conn.getResponseCode()==200) {
                InputStream is = conn.getInputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = in.readLine()) != null){
                    buffer.append(line);
                }
                msg = buffer.toString();

                System.out.println("成绩2: "+msg);
                return msg;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }


    public String getStringFromStream(InputStream in, int len) throws UnsupportedEncodingException, IOException {
        Reader reader = null;
        reader = new InputStreamReader(in, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}
