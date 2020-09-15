package app.kushagra.takeoff.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.layout_base.*

abstract class BaseFragment<T:BaseViewModel> : Fragment() {

    lateinit var viewModel:T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        container.addView(LayoutInflater.from(activity).inflate(setLayout(), container, false))
        viewModel =setViewModel()
        viewModel.inProgress.observe(this, Observer {
                inProgress->handleProgress(inProgress)
        })
        viewModel.error.observe(this, Observer {
            //handle exceptions
        })
    }

    fun handleProgress(inProgress: Boolean){
        if(inProgress){
            rl_progress.visibility = View.VISIBLE
        }else{
            rl_progress.visibility = View.GONE
        }
    }

    abstract fun setViewModel(): T

    abstract fun setLayout(): Int
}