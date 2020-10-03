package app.kushagra.takeoff.sections.pricing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.kushagra.takeoff.R
import app.kushagra.takeoff.adapters.MenuRecyclerAdapter
import app.kushagra.takeoff.base.BaseActivity

class PricingActivity : BaseActivity<PricingVM>() {

    lateinit var recyclerViewPrice:RecyclerView
    lateinit var adapter:MenuRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()
        initObservers()

        viewModel.getPriceList()
    }

    fun initObservers(){
        viewModel.responsePriceList.observe(this, Observer {
            adapter = MenuRecyclerAdapter(it,this)
            recyclerViewPrice.adapter = adapter
        })
    }

    fun initRecyclerView(){
        recyclerViewPrice = findViewById(R.id.recyclerViewPrice)
        recyclerViewPrice.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL, false)

    }

    override fun setViewModel(): PricingVM = ViewModelProviders.of(this)[PricingVM::class.java]

    override fun setLayout(): Int = R.layout.activity_pricing
}