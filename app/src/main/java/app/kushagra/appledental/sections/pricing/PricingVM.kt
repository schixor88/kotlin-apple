package app.kushagra.appledental.sections.pricing

import androidx.lifecycle.MutableLiveData
import app.kushagra.appledental.base.BaseViewModel
import app.kushagra.appledental.model.PriceModel

class PricingVM : BaseViewModel() {

    val responsePriceList by lazy { MutableLiveData<ArrayList<PriceModel>>() }

    fun getPriceList() {
        val dataList = ArrayList<PriceModel>()
        dataList.add(
            PriceModel(
                "1.",
                "Ticket, Checkup & Counseling",
                "Rs.300",
                true,
                "Description",
                ArrayList()
            )
        )
        dataList.add(PriceModel("2.", "X-ray", "Rs.300", false, "Description", ArrayList()))
        dataList.add(
            PriceModel(
                "3.",
                "Scaling & Polishing",
                "Rs.1200 - Rs.2000",
                true,
                "Description",
                getScalingList()
            )
        )
        dataList.add(
            PriceModel(
                "4.",
                "Tooth Colored (Composite) Filling",
                "Rs.1000 - Rs.2000",
                true,
                "Description",
                getToothColorList()
            )
        )
        dataList.add(
            PriceModel(
                "5.",
                "Glass Ionomer Cement (GIC) Restoration",
                "Rs.500 - Rs.1000",
                true,
                "Description",
                ArrayList()
            )
        )
        dataList.add(
            PriceModel(
                "6.",
                "Pulpectomy",
                "Rs.3000",
                true,
                "Description",
                ArrayList()
            )
        )
        dataList.add(
            PriceModel(
                "7.",
                "Root Canal Treatment (RCT)",
                "Rs.4000 - Rs.7000",
                true,
                "Description",
                getRootCanalList()
            )
        )
        dataList.add(
            PriceModel(
                "8.",
                "Artificial Teeth",
                "Rs.2000 - Rs.40000",
                true,
                "Description",
                getArtificialTeethList()
            )
        )
        dataList.add(
            PriceModel(
                "9.",
                "Orthodontic Treatment",
                "Rs.3000 - Rs.150000",
                true,
                "Description",
                getOrthodonticList()
            )
        )
        dataList.add(
            PriceModel(
                "10.",
                "Simple Extraction",
                "Rs.500 - Rs.3000",
                true,
                "Description",
                ArrayList()
            )
        )
        dataList.add(
            PriceModel(
                "11.",
                "Surgical Extraction",
                "Rs.5000 - Rs.10000",
                true,
                "Description",
                ArrayList()
            )
        )
        dataList.add(
            PriceModel(
                "12.",
                "Minor Oral Surgical Procedures",
                "Rs.3500 - Rs.8000",
                true,
                "Description",
                ArrayList()
            )
        )
        dataList.add(PriceModel("13.", "Implantology", "Rs.300", false, "Description", ArrayList()))
        dataList.add(
            PriceModel(
                "13.",
                "Inlay Onlay Post & Core",
                "Rs.60000 - Rs.150000",
                true,
                "Description",
                ArrayList()
            )
        )
        responsePriceList.value = dataList
    }

    private fun getScalingList(): ArrayList<PriceModel> {
        val subDataList = ArrayList<PriceModel>()
        subDataList.add(
            PriceModel(
                "3.1.",
                "Simple Scaling & Polishing",
                "Rs.1200",
                true,
                "Description",
                ArrayList()
            )
        )
        subDataList.add(
            PriceModel(
                "3.2",
                "Complex Scaling & Polishing",
                "Rs.2000",
                true,
                "Description",
                ArrayList()
            )
        )
        return subDataList

    }

    private fun getToothColorList(): ArrayList<PriceModel> {
        val subDataList = ArrayList<PriceModel>()
        subDataList.add(
            PriceModel(
                "4.1.",
                "Small",
                "Rs.1000",
                true,
                "Description",
                ArrayList()
            )
        )
        subDataList.add(
            PriceModel(
                "4.2",
                "Medium",
                "Rs.1500",
                true,
                "Description",
                ArrayList()
            )
        )
        subDataList.add(
            PriceModel(
                "3.3",
                "Large",
                "Rs.2000",
                true,
                "Description",
                ArrayList()
            )
        )
        return subDataList

    }

    private fun getRootCanalList(): ArrayList<PriceModel> {
        val subDataList = ArrayList<PriceModel>()
        subDataList.add(
            PriceModel(
                "7.1.",
                "Anterior Tooth",
                "Rs.4000",
                true,
                "Description",
                ArrayList()
            )
        )
        subDataList.add(
            PriceModel(
                "7.2",
                "Posterior Tooth",
                "Rs.7000",
                true,
                "Description",
                ArrayList()
            )
        )
        return subDataList

    }

    private fun getArtificialTeethList(): ArrayList<PriceModel> {
        val subDataList = ArrayList<PriceModel>()
        subDataList.add(
            PriceModel(
                "8.1.",
                "Complete Denture",
                "Rs.25000 - Rs.40000",
                true,
                "Description",
                ArrayList()
            )
        )
        subDataList.add(
            PriceModel(
                "8.2",
                "Partial Denture",
                "Rs.2000 + 500 per tooth",
                true,
                "Description",
                ArrayList()
            )
        )
        subDataList.add(
            PriceModel(
                "8.3",
                "Crowns",
                "Rs.2000 + 500 per tooth",
                true,
                "Description",
                ArrayList()
            )
        )
        return subDataList

    }

    private fun getOrthodonticList(): ArrayList<PriceModel> {
        val subDataList = ArrayList<PriceModel>()
        subDataList.add(
            PriceModel(
                "9.1.",
                "Removal Appliances",
                "Rs.3000 - Rs.5000",
                true,
                "Description",
                ArrayList()
            )
        )
        subDataList.add(
            PriceModel(
                "9.2",
                "Braces (Metallic)",
                "Rs.45000 - Rs.80000",
                true,
                "Description",
                ArrayList()
            )
        )
        subDataList.add(
            PriceModel(
                "9.3",
                "Braces (Ceramic)",
                "Rs.60000 - Rs.80000",
                true,
                "Description",
                ArrayList()
            )
        )
        subDataList.add(
            PriceModel(
                "9.4",
                "Clear Aligner",
                "Rs.100000 - Rs.150000",
                true,
                "Description",
                ArrayList()
            )
        )
        return subDataList

    }

}