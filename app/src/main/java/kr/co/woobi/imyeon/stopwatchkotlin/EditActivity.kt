package kr.co.woobi.imyeon.stopwatchkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.activity_edit.*
import java.util.*

class EditActivity : AppCompatActivity() {
    val realm = Realm.getDefaultInstance()
    val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
//
//        val id=intent.get
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    private fun insertTodo() {
        realm.beginTransaction()

//        val newItem = realm.createObject<Todo>(nextId())
//        newItem.title = edit_todo.text.toString()
//        newItem.date = calendar.timeInMillis
//
//        realm.commitTransaction()
//
//        alert("내용이 추가되었습니다.") {
//            yesButton { finish() }
//        }.show()
    }

//    private fun nextId(): Int {
//        val maxId = realm.where<Todo>().max("id")
//        if (maxId != null) {
//            return maxId.toInt() + 1
//        }
//        return 0
//    }



    private fun updateTodo(id:Long){
//        realm.beginTransaction()
//
//        val updateItem=realm.where<Todo>().equalTo("id", id).findFirst()!!
//        updateItem.title = edit_todo.text.toString()
//        updateItem.date=calendar.timeInMillis
//
//        realm.commitTransaction()
//        alert("내용이 변경되었습니다."){
//            yesButton{
//                finish()
//            }.show()
//        }
    }

    private fun deleteTodo(id:Long){
//        realm.beginTransaction()
//        val deleteItem = realm.where<Todo>().equalTo("id", id).findFirst()!!
//        deleteItem.deleteFromRealm()
//        realm.commitTransaction()

//        alert("내용이 삭제되었습니다."){
//            yesButton{finish()}
//        }.show()
    }
}
