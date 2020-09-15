package app.kushagra.takeoff.base

import androidx.fragment.app.Fragment

abstract class CoordinatedFragment : Fragment() {

    abstract fun getTitle():String
}