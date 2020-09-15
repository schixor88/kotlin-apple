package app.kushagra.takeoff.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import app.kushagra.takeoff.R
import kotlinx.android.synthetic.main.layout_base.*

abstract class BaseActivity <T:BaseViewModel> : AppCompatActivity() {

    private lateinit var TAG:String
    lateinit var viewModel: T

    var lockToolbarTitle: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_base)

        container.addView(LayoutInflater.from(this).inflate(setLayout(), container, false))
        viewModel =setViewModel()
        viewModel.inProgress.observe(this, Observer {
                inProgress->handleProgress(inProgress)
        })
        viewModel.error.observe(this, Observer {
            //handle exceptions
        })
    }

    fun updateToolbarTitle(title: String) {
        if (supportActionBar != null) supportActionBar!!.title = title
    }

    //transacting or moving between fragments
    lateinit var pages: Array<Fragment>
    protected var addToBackStack: Boolean = true
    var activePage: Int = 0

    fun transactTo(index: Int) {
        var title: String = ""
        if (pages.isEmpty()) throw RuntimeException("No Fragments pages were setup");
        if (pages[index] is CoordinatedFragment && !lockToolbarTitle) {
            title = (pages[index] as CoordinatedFragment).getTitle()
            if (title.isEmpty()) {
                title = "PrabhuPAY";
            }
            updateToolbarTitle(title)
        }
        transitionFragment(pages[index], addToBackStack, title)
        activePage = index

    }

    fun transitionFragment(fragment: Fragment, addToBackStack: Boolean, name: String) {
        runOnUiThread {
            var transaction: FragmentTransaction = supportFragmentManager.beginTransaction();
            transaction.add(R.id.fragment, fragment)
            if (addToBackStack) transaction.addToBackStack(name)
            try {
                if (!isFinishing) transaction.commit()
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }

    fun onBackPressedAction() {
        if (viewModel.inProgress.value == false) {
            if (activePage <= 0) finish()
            else {
                --activePage
                supportFragmentManager.popBackStack()
            }
            if (lockToolbarTitle) return
            var fragment: Fragment = pages[activePage]
            var title: String = ""

            if (fragment is CoordinatedFragment) {
                title = (fragment as CoordinatedFragment).getTitle()
            }
            updateToolbarTitle(title)
        }

    }

    private fun handleProgress(inProgress: Boolean) {

        if (inProgress) {
            if (rl_progress.visibility == View.GONE) {
                rl_progress.animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
                rl_progress.visibility = View.VISIBLE
            }
        } else {
            rl_progress.animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
            rl_progress.visibility = View.GONE
        }
    }

    protected fun setUpToolbar() {

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_back)
            toolbar.setNavigationOnClickListener { v -> onBackPressed() }
        }
    }

    abstract fun setViewModel(): T

    abstract fun setLayout(): Int


    //some bottomnavs librarys
    /*
   * https://github.com/ibrahimsn98/SmoothBottomBar
   * https://github.com/gauravk95/bubble-navigation
   *
   * this is the one : https://github.com/oneHamidreza/MeowBottomNavigation
   *
   * snapchat : https://github.com/nirukk52/SnapTabLayout
   *
   * clean : https://github.com/Droppers/AnimatedBottomBar
   *
   * cool : https://github.com/pedromassango/titled_navigation_bar
   *
   * play store: https://github.com/timrijckaert/BetterBottomBar
   *
   * move? https://github.com/mehrtarh/CircleButtonBar
   *
   * google: https://github.com/jimmy-robert/BottomNavigationCircularColorReveal
   * */
}