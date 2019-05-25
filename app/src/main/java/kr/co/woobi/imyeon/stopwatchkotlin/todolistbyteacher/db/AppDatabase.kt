package kr.co.woobi.imyeon.stopwatchkotlin.todolistbyteacher.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract  class AppDatabase :RoomDatabase(){
    abstract  fun todoDao():TodoDao
}