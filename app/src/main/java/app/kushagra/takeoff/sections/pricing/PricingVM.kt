package app.kushagra.takeoff.sections.pricing

import androidx.lifecycle.MutableLiveData
import app.kushagra.takeoff.base.BaseViewModel
import app.kushagra.takeoff.model.PriceModel

class PricingVM : BaseViewModel() {

    val responsePriceList by lazy { MutableLiveData<ArrayList<PriceModel>>() }

    fun getPriceList(){
        val dataList = ArrayList<PriceModel>()
        dataList.add(PriceModel("1.","Ticket, Checkup & Counseling", "Rs.3000-Rs.6000",false, "Description", ArrayList()))
        dataList.add(PriceModel("2.","X-ray", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("3.","Scaling & Polishing", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("4.","Tooth Color Composite Filling", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("5.","GIC Restoration", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("6.","Pulpectomy", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("7.","RCT Root Canal Treatment", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("8.","Artificial Teeth", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("9.","Orthodontic Treatment", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("10.","Simple Extraction", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("11.","Surgical Extraction", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("12.","Minor Oral Surgical Procedures", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("13.","Implantology", "Rs.300",false, "Description", ArrayList()))
        dataList.add(PriceModel("13.","Inlay Onlay Post & Core", "Rs.300",false, "Description", ArrayList()))
        responsePriceList.value = dataList
    }

}