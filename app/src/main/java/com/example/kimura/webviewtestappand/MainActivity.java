package com.example.kimura.webviewtestappand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView wv = (WebView)findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                EditText txt = (EditText)findViewById(R.id.edtUrl);
                txt.setText(url);
                return false;
            }
        });

        // GO
        Button btn = (Button)findViewById(R.id.btn_GO);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText txt = (EditText)findViewById(R.id.edtUrl);
                WebView wv = (WebView)findViewById(R.id.webView);
                String url = txt.getText().toString();
                wv.loadUrl(url);
            }
        });
        // NEXT
        btn = (Button)findViewById(R.id.btn_Prev);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                WebView wv = (WebView)findViewById(R.id.webView);
                if( wv.canGoBack()) {
                    wv.goBack();
                }
            }
        });
        // PREVIOUS
        btn = (Button)findViewById(R.id.btn_Next);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                WebView wv = (WebView)findViewById(R.id.webView);
                if( wv.canGoForward()) {
                    wv.goForward();
                }
            }
        });
    }
}
