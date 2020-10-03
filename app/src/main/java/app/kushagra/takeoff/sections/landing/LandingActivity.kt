package app.kushagra.takeoff.sections.landing

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.kushagra.takeoff.R
import app.kushagra.takeoff.adapters.RoundedButtonRecyclerAdapter
import app.kushagra.takeoff.base.BaseActivity
import app.kushagra.takeoff.model.QuickDataModel
import app.kushagra.takeoff.web.WebViewActivity
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : BaseActivity<LandingVM>() {

    lateinit var recyclerViewQuickAccess:RecyclerView
    lateinit var recyclerQuickAdapter:RoundedButtonRecyclerAdapter
    var dataQuickArrayList = ArrayList<QuickDataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerViewQuick()
        initObservers()

        viewModel.getQuickData(this)

        card_appointment.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

    }

    private fun initObservers(){

        viewModel.responseQuickNav.observe(this, Observer {
            dataQuickArrayList = it
            recyclerQuickAdapter = RoundedButtonRecyclerAdapter(dataQuickArrayList, this)
            recyclerViewQuickAccess.adapter = recyclerQuickAdapter
        })
    }

    private fun initRecyclerViewQuick(){
        recyclerViewQuickAccess = findViewById(R.id.recyclerViewQuick)
        recyclerViewQuickAccess.layoutManager = GridLayoutManager(this, 4)
        recyclerQuickAdapter = RoundedButtonRecyclerAdapter(dataQuickArrayList, this)
        recyclerViewQuickAccess.adapter = recyclerQuickAdapter
    }

    override fun setViewModel(): LandingVM  = ViewModelProviders.of(this)[LandingVM::class.java]

    override fun setLayout(): Int = R.layout.activity_landing
}