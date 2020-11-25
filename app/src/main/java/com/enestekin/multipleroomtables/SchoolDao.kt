package com.enestekin.multipleroomtables

import androidx.room.*
import com.enestekin.multipleroomtables.entities.Director
import com.enestekin.multipleroomtables.entities.School
import com.enestekin.multipleroomtables.entities.Student
import com.enestekin.multipleroomtables.entities.Subject
import com.enestekin.multipleroomtables.entities.relations.*
@Dao
interface SchoolDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction //thread
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun  getSchoolAndDirectorWithSchoolName(schoolName : String) : List<SchoolAndDirector>


    @Transaction
    @Query ("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun  getSchoolWithStudents (schoolName : String) : List<SchoolWithStudents>

    @Transaction //thread
    @Query("SELECT * FROM subject  WHERE subjectName = :subjectName")
    suspend fun  getStudentsOfSubject(subjectName : String) : List<SubjectWithStudents>

    @Transaction //thread
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun  getSubjectsOfStudent(studentName : String) : List<StudentWithSubjects>

}