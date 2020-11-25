package com.enestekin.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.enestekin.multipleroomtables.entities.School
import com.enestekin.multipleroomtables.entities.Student

data class SchoolWithStudents (
    @Embedded  val school : School, // main table
@Relation(
    parentColumn = "schoolName",
    entityColumn =   "schoolName"
)

val students : List<Student>
)