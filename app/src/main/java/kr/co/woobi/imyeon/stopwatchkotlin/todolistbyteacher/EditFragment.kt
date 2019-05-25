package kr.co.woobi.imyeon.stopwatchkotlin.todolistbyteacher


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_edit.*
import kr.co.woobi.imyeon.stopwatchkotlin.R
import kr.co.woobi.imyeon.stopwatchkotlin.databinding.FragmentEditBinding.*
import java.util.*


class EditFragment : Fragment() {
    private var date: Long = 0

    val args: EditFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = bind(view)
        val viewModel = ViewModelProviders.of(requireActivity()).get(TodoListViewModel::class.java)

        date = calendarView2.date
        val todo = args.todo

        binding.todo = args.todo

        calendarView2.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            val timeInMillis = calendar.timeInMillis
            date = timeInMillis
        }

        button_done.setOnClickListener {
            val title = todo_edit.text.toString()
            todo.title = title
            todo.date = date
            viewModel.update(todo)
            findNavController().popBackStack()
        }
        button_delete.setOnClickListener {
            viewModel.delete(todo)
            findNavController().popBackStack()
        }

    }
}
