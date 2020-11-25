package com.enestekin.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.enestekin.multipleroomtables.entities.Director
import com.enestekin.multipleroomtables.entities.School

//How to work table together

data class SchoolAndDirector(

    @Embedded val school : School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director


)