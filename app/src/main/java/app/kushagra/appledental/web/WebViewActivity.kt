package app.kushagra.appledental.web

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import app.kushagra.appledental.R
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.progress_bar.*

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url = "https://docs.google.com/forms/d/e/1FAIpQLSeiqdAcWctnZFoHw01jIIO5oIEXVW2_Q5bdI8wd9dA2kQVwnA/viewform"

        web_view.settings.javaScriptEnabled = true

        web_view.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progress_bar.visibility = View.VISIBLE
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                progress_bar.visibility = View.VISIBLE
                view?.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progress_bar.visibility = View.GONE
            }

        }

        web_view.loadUrl(url)


    }
}