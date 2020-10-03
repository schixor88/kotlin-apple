package app.kushagra.appledental.sections.doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.kushagra.appledental.R
import app.kushagra.appledental.adapters.DoctorRecyclerAdapter
import app.kushagra.appledental.base.BaseActivity

class DoctorActivity : BaseActivity<DoctorVM>() {

    lateinit var recyclerViewDoctor: RecyclerView
    lateinit var adapter: DoctorRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObserver()
        initRecyclerView()

        viewModel.getDoctorList()

    }

    fun initRecyclerView() {
        recyclerViewDoctor = findViewById(R.id.recyclerViewDoctor)
        recyclerViewDoctor.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }

    fun initObserver() {
        viewModel.responseDoctorList.observe(this, Observer {
            adapter = DoctorRecyclerAdapter(it, this)
            recyclerViewDoctor.adapter  = adapter
        })
    }

    override fun setViewModel(): DoctorVM = ViewModelProviders.of(this)[DoctorVM::class.java]

    override fun setLayout(): Int = R.layout.activity_doctor
}