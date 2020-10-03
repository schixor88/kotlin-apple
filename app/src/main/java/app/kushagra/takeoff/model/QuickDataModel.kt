package app.kushagra.takeoff.model

import android.graphics.drawable.Drawable
import app.kushagra.takeoff.R

data class QuickDataModel(
    var title:String?="",
    var image:Drawable?=null,
    var background:Int? = null,
    var mapId:Int?=0
)