package app.kushagra.appledental.model

data class PriceModel(
    var number:String?="",
    var name:String?="",
    var rate:String?="",
    var isClickable:Boolean=false,
    var description:String?="",
    var subModel:ArrayList<PriceModel>
)