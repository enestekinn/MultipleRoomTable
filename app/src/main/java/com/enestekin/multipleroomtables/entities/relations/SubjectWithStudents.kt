package com.enestekin.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.enestekin.multipleroomtables.entities.Student
import com.enestekin.multipleroomtables.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject : Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects : List<Student>
)