package com.example.deliverykotlin.components.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliverykotlin.data.*
import java.util.*

class MenuViewModel: ViewModel() {
    var param=MutableLiveData<Param>(Param.BRAND)
    var paramFinding= MutableLiveData<String>()
    var position: Int=0

    fun getMenuList():MutableLiveData<MutableList<MyEntity>>{
        var list=getEntityList()
        when(param.value){
            Param.BRAND ->
                Collections.sort(list, { o1, o2 -> o1.brand.compareTo(o2.brand) })
            Param.TYPE ->
                Collections.sort(list, { o1, o2 -> o1.type.compareTo(o2.type) })
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
    fun findPosition(list: MutableList<MyEntity>):Int{
        var i=0
        for (entity in list){
            if (paramFinding.value.equals(entity.brand)||
                paramFinding.value.equals(entity.type) ){
                return i
            }
            i++
        }
        return i
    }
}
enum class Param{
    BRAND, TYPE
}