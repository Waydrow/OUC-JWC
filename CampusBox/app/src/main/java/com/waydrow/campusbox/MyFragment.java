package com.waydrow.campusbox;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {

    private String content;
    private int flag;   // 1为string, 2为webview, 3为图片

    public MyFragment(String content,int flag) {
        super();
        this.content = content;
        this.flag = flag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        WebView webView = (WebView) view.findViewById(R.id.webView);
        if(flag==1) {
            txt_content.setText(content);
        } else if(flag==2) {
//            webView.loadDataWithBaseURL("",content,"text/html","UTF-8","");
            webView.loadUrl("http://192.168.1.27/ImageCup/index.php/Home/index/score");
        }
        return view;
    }

}
