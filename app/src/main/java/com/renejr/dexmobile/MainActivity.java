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

        //Abrir no App em vez do navegador.
        webView.setWebViewClient(new BrowserClient());
        webView.setWebChromeClient(new MyChromeClient());

        //Pegar o JS e jogar para o APP.
        webView.getSettings().setJavaScriptEnabled(true);

        //Salvar na memória do celular.
        webView.getSettings().setDomStorageEnabled(true);

        loadWebPage();
    }

    // função para carregar a página
    private void loadWebPage() {
        webView.loadUrl("https://victorhq.github.io/WebDex/");

    }

    // Função para voltar sem fechar o app.
    @Override
    public void onBackPressed(){


        if (webView.canGoBack()){
            webView.goBack();
        } else {

            super.onBackPressed();
        }
    }
}