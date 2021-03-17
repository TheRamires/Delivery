package com.example.deliverykotlin.components.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliverykotlin.data.*
import java.util.*

class MenuViewModel: ViewModel() {
    var menuLive=MutableLiveData<MutableList<MyEntity>>()

    fun getMenuList(){
        var list=getEntityList()
        Collections.sort(list, kotlin.Comparator { o1, o2 -> o1.brand.compareTo(o2.brand) })
        menuLive.setValue(list)
    }
    fun getSection1Live():MutableLiveData<MutableList<Brand>>{
        var list= getBrandList()
        return MutableLiveData<MutableList<Brand>>(list)
    }
    fun getSection2Live():MutableLiveData<MutableList<Type>> {
        var list= getTypeList()
        return MutableLiveData<MutableList<Type>>(list)
    }
}