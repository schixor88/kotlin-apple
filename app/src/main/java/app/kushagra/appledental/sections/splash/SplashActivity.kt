package app.kushagra.appledental.sections.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.lifecycle.ViewModelProviders
import app.kushagra.appledental.R
import app.kushagra.appledental.base.BaseActivity
import app.kushagra.appledental.sections.landing.LandingActivity

class SplashActivity : BaseActivity<SplashVM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        supportActionBar?.hide();

        intentActivity(LandingActivity::class.java, 2500)


    }

    private fun intentActivity(activity: Class<*>, int: Long){
        Handler().postDelayed({
            val i = Intent(this, activity)
            startActivity(i)
            finish()
        }, int
        )
    }

    override fun setViewModel(): SplashVM = ViewModelProviders.of(this)[SplashVM::class.java]

    override fun setLayout(): Int = R.layout.activity_splash
}