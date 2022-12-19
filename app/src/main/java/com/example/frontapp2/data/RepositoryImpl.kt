package com.example.frontapp2.data

import android.content.Context
import com.example.frontapp2.domain.Repository
import com.example.frontapp2.domain.models.Student

class RepositoryImpl(private val context: Context) : Repository{

    private var currentId: Int = 0
    private var students = mutableListOf<Student>()

    private var currentImage: String = "https://s766sas.storage.yandex.net/rdisk/9b32e85b43d698129bd709f88d30b2ee9798995f9eaff030a71c151632f51f03/639fb88e/cBmbvSqoPLGh7QN2XuyV4eTWoo8LGM72uZ5u5m7xuYjkHYeXmfS_7AcT1c0mO20A0Jw9H2A9S2TNmJ-Roadi4Q==?uid=0&filename=Kit.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&owner_uid=0&fsize=765850&hid=f03f14f6ff61533f77a850b12dde10a2&media_type=image&tknv=v2&etag=896748b4913d69399e2e0c6357e7e206&rtoken=k4AVIFnJ2URY&force_default=no&ycrid=na-ab789d5b295d7fcbc4fd964646a21aa4-downloader16h&ts=5f023e5d4bf80&s=fe2d172a1c5e8b6a78b6f7913c08fc18ece7cbb1c5d5b94e2cdf4ee6d5b7998f&pb=U2FsdGVkX1_oCAsM2cRFyj7jZ_OHG0E3DyWTWmj_XrkY4sKh9LpQbiUyMO3HTj4umKNWKLOimrO7doZbjD6AUK6OvMLtFqWogVzDTnVGpLE"

    init {
        students.add(0,Student(0, "Evgeniy", "Cherkasov", "4936", "https://sun9-north.userapi.com/sun9-83/s/v1/ig2/Sw3KXe3CHAdEh9x5IjNU5GPuqTrrF_-3kNl_d450cwefgZBSnsh3grxBAYZiftHtyQTSIroyNnh_RSpVtpy_mAit.jpg?size=900x920&quality=96&type=album"))
        students.add(1,Student(1, "Alexander", "Krutov", "4936"))
        students.add(2,Student(2, "Rakhim", "Zinatov", "4936"))
        students.add(3,Student(3, "Michael", "Nesterenko", "4936"))
        students.add(4,Student(4, "Ivan", "Potapov", "1234"))
        students.add(5,Student(5, "Evgeniy2", "Cherkasov2", "4936", "https://sun9-north.userapi.com/sun9-83/s/v1/ig2/Sw3KXe3CHAdEh9x5IjNU5GPuqTrrF_-3kNl_d450cwefgZBSnsh3grxBAYZiftHtyQTSIroyNnh_RSpVtpy_mAit.jpg?size=900x920&quality=96&type=album"))
        students.add(6,Student(6, "Alexander2", "Krutov2", "4936"))
        students.add(7,Student(7, "Rakhim2", "Zinatov2", "4936"))
        students.add(8,Student(8, "Michael2", "Nesterenko2", "4936"))
        students.add(9,Student(9, "Ivan2", "Potapov2", "1234"))
        currentId = 10
    }


    override fun getStudents(): List<Student> {
        return students
    }

    override fun addStudent(firstName: String, secondName: String, groupNum: String): Boolean {
        students.add(Student(currentId, firstName, secondName, groupNum))
        currentId++
        return true
    }

    override fun addStudent(firstName: String, secondName: String, groupNum: String, photo:String): Boolean {
        students.add(Student(currentId, firstName, secondName, groupNum, photo))
        currentId++
        return true
    }

    override fun deleteStudent(id: Int): Boolean {
        val indexToDelete :Int = students.indexOfFirst { it.id == id }
        if (indexToDelete != -1) {
            students = ArrayList(students)
            students.removeAt(indexToDelete)
        }
        return true
    }

    override fun getStudent(id: Int): Student {
        return students.get(id)
    }

    override fun setImage(url: String): Boolean {
        currentImage = url
        return true
    }

    override fun getImage(): String {
        return currentImage
    }

}