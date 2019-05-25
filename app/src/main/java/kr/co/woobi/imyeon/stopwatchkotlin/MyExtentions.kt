package kr.co.woobi.imyeon.stopwatchkotlin

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.R.string.cancel
import android.content.DialogInterface
import androidx.core.content.ContextCompat


fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}

fun Any.logd(text: String) {
    Log.d(this::class.java.simpleName, text)
}

