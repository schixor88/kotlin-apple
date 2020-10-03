package app.kushagra.appledental.model

import android.graphics.drawable.Drawable

data class QuickDataModel(
    var title:String?="",
    var image:Drawable?=null,
    var background:Int? = null,
    var mapId:Int?=0
)