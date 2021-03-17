package com.example.deliverykotlin.components.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliverykotlin.Loger
import com.example.deliverykotlin.data.*
import java.util.*

class MenuViewModel: ViewModel() {
    var param: Param= Param.BRAND

    fun getMenuList():MutableLiveData<MutableList<MyEntity>>{
        var list=getEntityList()
        when(param){
            Param.BRAND->
                Collections.sort(list, { o1, o2 -> o1.brand.compareTo(o2.brand) })
            Param.TYPE->
                Collections.sort(list,{o1,o2->o1.type.compareTo(o2.type)})
        }
        return MutableLiveData<MutableList<MyEntity>>(list)
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
enum class Param{
    BRAND, TYPE
}