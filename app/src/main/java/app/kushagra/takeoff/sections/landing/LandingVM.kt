package app.kushagra.takeoff.sections.landing

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import app.kushagra.takeoff.R
import app.kushagra.takeoff.base.BaseViewModel
import app.kushagra.takeoff.model.QuickDataModel

class LandingVM : BaseViewModel() {

    val responseQuickNav by lazy { MutableLiveData<ArrayList<QuickDataModel>>() }

    fun getQuickData( context: Context){
        val dataArrayList = ArrayList<QuickDataModel>()

        dataArrayList.add(QuickDataModel(
            "Services",
            context.resources.getDrawable(R.drawable.ic_013_crown),
            ContextCompat.getColor(context,R.color.btn_login_twitter),
            1
            )
        )

        dataArrayList.add(QuickDataModel(
            "Team",
            context.resources.getDrawable(R.drawable.ic_017_dentist),
            ContextCompat.getColor(context,R.color.common_green),
            2
        )
        )

        dataArrayList.add(QuickDataModel(
            "Contact",
            context.resources.getDrawable(R.drawable.ic_013_crown),
            ContextCompat.getColor(context,R.color.common_yellow),
            3
        )
        )

        dataArrayList.add(QuickDataModel(
            "Gallery",
            context.resources.getDrawable(R.drawable.ic_008_love),
            ContextCompat.getColor(context,R.color.btn_login_twitter_pressed),
            4
        )
        )

       responseQuickNav.value = dataArrayList

    }
}