package com.example.administrator.myapplication

/**
 * Created by Administrator on 2017/9/11 0011.
 */
data class Person(val name:String,val age:Int?=null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob",29))
    val oldest =persons.maxBy { it.age?:0 }
    println ("The oldest is :$oldest")

}