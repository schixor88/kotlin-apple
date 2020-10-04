package app.kushagra.appledental.base

import androidx.fragment.app.Fragment

abstract class CoordinatedFragment : Fragment() {

    abstract fun getTitle():String
}