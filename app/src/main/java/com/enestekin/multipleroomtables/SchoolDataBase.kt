package com.enestekin.multipleroomtables

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.enestekin.multipleroomtables.entities.Director
import com.enestekin.multipleroomtables.entities.School
import com.enestekin.multipleroomtables.entities.Student
import com.enestekin.multipleroomtables.entities.Subject
import com.enestekin.multipleroomtables.entities.relations.StudentSubjectCrossRef


@Database(
    entities = [
    School::class,
    Student::class,
    Director::class,
    Subject::class,
    StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDataBase  : RoomDatabase() {

    abstract val schoolDao : SchoolDao

    companion object {

        @Volatile
        private var INSTANCE : SchoolDataBase? = null

        fun getInstance(context : Context) : SchoolDataBase {
            synchronized(this) {

                return  INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDataBase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }

            }
        }
    }

}