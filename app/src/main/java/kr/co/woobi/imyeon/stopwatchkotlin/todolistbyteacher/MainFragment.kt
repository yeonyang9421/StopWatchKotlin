package kr.co.woobi.imyeon.stopwatchkotlin.todolistbyteacher


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*
import kr.co.woobi.imyeon.stopwatchkotlin.R
import kr.co.woobi.imyeon.stopwatchkotlin.databinding.ItemTodoBinding.bind
import kr.co.woobi.imyeon.stopwatchkotlin.todolistbyteacher.db.Todo

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(requireActivity())
            .get(TodoListViewModel::class.java)

        val adapter = TodoAdapter(
            clickListener = {
                //수정화면
                val action = MainFragmentDirections.actionMainFragmentToEditFragment(it)
                findNavController().navigate(action)
            },
            deleteClickLisener = {
                viewModel.delete(it)
            },
            updateClickListener = {
                val action = MainFragmentDirections.actionMainFragmentToEditFragment(it)
                findNavController().navigate(action)
            }
        )
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        viewModel.getAll().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        floatbutton_add.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }
    }
}

    class TodoAdapter(
        private val clickListener: (todo: Todo) ->Unit,
        private val deleteClickLisener:(todo: Todo)->Unit,
        private val updateClickListener:(todo: Todo)->Unit
    ):
        RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

        var items = listOf<Todo>()

        class TodoViewHolder (val binding:kr.co.woobi.imyeon.stopwatchkotlin.databinding.ItemTodoBinding):RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
            val view=LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
            val viewHolder=TodoViewHolder(bind(view))
            view.setOnClickListener{
                clickListener.invoke(items[viewHolder.adapterPosition])
            }
            viewHolder.binding.imageMore.setOnClickListener{
                val popupMenu=PopupMenu(parent.context, it)
                popupMenu.inflate(R.menu.popup_todo)
                popupMenu.show()

                popupMenu.setOnMenuItemClickListener { menuItem ->
                    val item = items[viewHolder.adapterPosition]
                    when(menuItem.itemId){
                        R.id.action_delete->{
                            deleteClickLisener.invoke(item)
                            true
                        }
                        R.id.action_update->{
                            updateClickListener.invoke(item)
                            true
                        }
                        else -> false
                    }
                }
            }
            return  viewHolder
        }

        override fun getItemCount()=items.size
        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
            holder.binding.todo=items[position]
        }
        }



