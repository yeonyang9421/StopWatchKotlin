package kr.co.woobi.imyeon.stopwatchkotlin.todolistbyteacher


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_add.*

import kr.co.woobi.imyeon.stopwatchkotlin.R
import kr.co.woobi.imyeon.stopwatchkotlin.todolistbyteacher.db.Todo
import java.util.*


class AddFragment : Fragment() {
    private var date: Long=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(requireActivity())
            .get(TodoListViewModel::class.java)

        date = calendarView.date

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            val timeInMillis = calendar.timeInMillis
            date = timeInMillis

        }
        done_button.setOnClickListener {
        val title = todo_edit.text.toString()

        viewModel.insert(Todo(title, date))
        it.findNavController().popBackStack()
    }
    }


}
