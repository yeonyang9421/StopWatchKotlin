package kr.co.woobi.imyeon.stopwatchkotlin


import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AlertFragment(private val onClickListener: () -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("권한이 필요한 이유")
        builder.setMessage("사진 정보를 얻으려면 외부 저장소 권한이 필수입니다.")
        builder.setPositiveButton("수락") { _, _ ->
            onClickListener.invoke()
        }
        builder.setNegativeButton("거부", null)
        return builder.create()
    }


}
