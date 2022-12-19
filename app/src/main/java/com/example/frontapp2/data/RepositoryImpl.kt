package com.example.frontapp2.data

import android.content.Context
import com.example.frontapp2.domain.Repository
import com.example.frontapp2.domain.models.Student

class RepositoryImpl(private val context: Context) : Repository{

    private var currentId: Int = 0
    private var students = mutableListOf<Student>()

    private var currentImage: String = "https://psv4.userapi.com/c237231/u169536553/docs/d47/de98f3b7f165/Mukha_Aret.png?extra=RvPCtpuZyvP0sdyTWJ8dxKnAHsC1pPYXubLKI445syh-iaiiCjXItO6eFpfagGAfD6JqCZXvLm9ghO4vuPeehGjVoLfEcLke_zj_2YmmZRluTnCO5IYwdnwJewcxPWSP7LXklkbZssWis-Pj25agEwfHeQ"

    init {
        students.add(0,Student(0, "Evgeniy", "Cherkasov", "4936", "https://sun9-north.userapi.com/sun9-83/s/v1/ig2/Sw3KXe3CHAdEh9x5IjNU5GPuqTrrF_-3kNl_d450cwefgZBSnsh3grxBAYZiftHtyQTSIroyNnh_RSpVtpy_mAit.jpg?size=900x920&quality=96&type=album"))
        students.add(1,Student(1, "Alexander", "Krutov", "4936"))
        students.add(2,Student(2, "Rakhim", "Zinatov", "4936", "https://psv4.userapi.com/c237231/u169536553/docs/d1/2e0c91c2e2f4/misery.png?extra=GM0AfGD-vICDLSXNecX_20dx1OPxYwrR94PJix26TyQIcbLUnYNrwgyztsMoXLqRjykiCfbXKdAa1Ut4JiBxvtrvjlaTx4d8KeUoIUn-fFUGYAU5huEknWp5r6GmLxaJUp5R72Fjca2_FbbXGWzga87K9w"))
        students.add(3,Student(3, "Michael", "Nesterenko", "4936"))
        students.add(4,Student(4, "Ivan", "Potapov", "1234"))
        students.add(5,Student(5, "Evgeniy2", "Cherkasov2", "4936", "https://sun9-north.userapi.com/sun9-83/s/v1/ig2/Sw3KXe3CHAdEh9x5IjNU5GPuqTrrF_-3kNl_d450cwefgZBSnsh3grxBAYZiftHtyQTSIroyNnh_RSpVtpy_mAit.jpg?size=900x920&quality=96&type=album"))
        students.add(6,Student(6, "Alexander2", "Krutov2", "4936"))
        students.add(7,Student(7, "Rakhim2", "Zinatov2", "4936", "https://psv4.userapi.com/c237231/u169536553/docs/d1/2e0c91c2e2f4/misery.png?extra=GM0AfGD-vICDLSXNecX_20dx1OPxYwrR94PJix26TyQIcbLUnYNrwgyztsMoXLqRjykiCfbXKdAa1Ut4JiBxvtrvjlaTx4d8KeUoIUn-fFUGYAU5huEknWp5r6GmLxaJUp5R72Fjca2_FbbXGWzga87K9w"))
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