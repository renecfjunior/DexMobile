package com.renejr.dexmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {
private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            webView = findViewById(R.id.webview);

        // Configurar o cliente da WebView para abrir a URL dentro da aplicação
        webView.setWebViewClient(new WebViewClient());

        // Ativar o JavaScript na WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Ativar o armazenamento de DOM na WebView
        webSettings.setDomStorageEnabled(true);

        // Carregar a URL na WebView
        webView.loadUrl("https://victorhq.github.io/WebDex/");
    }

    // Sobrescrever o método onBackPressed para permitir a navegação para trás na WebView
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
