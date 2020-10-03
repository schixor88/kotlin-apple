package app.kushagra.appledental.sections.doctor

import androidx.lifecycle.MutableLiveData
import app.kushagra.appledental.base.BaseViewModel
import app.kushagra.appledental.model.DoctorModel

class DoctorVM : BaseViewModel() {

    val responseDoctorList by lazy { MutableLiveData<ArrayList<DoctorModel>>() }

    fun getDoctorList(){

        val doctorList = ArrayList<DoctorModel>()
        doctorList.add(DoctorModel("Dr. Gaurav Acharya","10599","MDS (TU)", "Orthodontics & Dentofacial Orthopedics"))
        doctorList.add(DoctorModel("Dr. Luna Ghimire","22991","BDS (KU)", "Senior Dental Surgeon"))
        doctorList.add(DoctorModel("Dr. Kalu Singh Khatri","100034","MDS (JMU)", "Oral & Maxillofacial Surgery"))
        doctorList.add(DoctorModel("Dr.Nashib Pandey","11568","MDS (TU)", "Periodontology & Oral Implantology"))
        doctorList.add(DoctorModel("Dr. Subodh Lal Karna","12574","MDS (TU)", "Prosthodontics & Maxillofacial Prothesis"))
        doctorList.add(DoctorModel("Dr. Surendra Acharya","12574","MDS (AIIMS)", "Oral Maxillofacial & Cosmetic Surgery"))

        responseDoctorList.value = doctorList

    }
}