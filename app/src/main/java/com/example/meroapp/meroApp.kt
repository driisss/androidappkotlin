package com.example.meroapp

fun main(){
    println("hello world")

    // var name = "Dristi"
    //name = "Aashika"

    //mutable var
    var firstname = "Dristi"
    var lastname = "Sapkota"

    //to print in kotlin
    println("${firstname.length} $lastname")

    //to declare variable (name deyera)
    var name : String = "Dristi"
    var age: Int = 10

    //array
    // var address = arrayOf("ktm","pokhara","chitwan")
    //to access array list
    var address = arrayListOf("ktm","Pokhara")
    address.add("pokhara")

    //dictionary
    var dictionary = mapOf(
        "Apple" to "this is fruit",
        "samsung" to "this is a brand"
    )

    print("the value ofg apple is $dictionary")

    //for loop
    for(i in 0..5){
        println(i)
    }

    //operators
    var num1: Double = 10.6
    var num2: Double = 5.0
    var result: Double = 0.0
    result = num1 + num2
    println("num1 + num2 is $result")
    result = num1 - num2
    println("num1 - num2 is $result")
    result = num1 * num2
    println("num1 * num2 is $result")
    result = num1 / num2
    println("num1 / num2 is $result")
    result = num1 % num2
    println("num1 % num2 is $result")


    //when loop
    print("Please enter a day number of week: ")
    var dayNumber: Int = readln()!!.toInt()
    var day: String
    when (dayNumber)
    {
        1 -> day = "Sunday"
        2 -> day = "Monday"
        3 -> day = "Tuesday"
        4 -> day = "Wednesday"
        5 -> day = "Thursday"
        6 -> day = "Friday"
        7 -> day = "Saturday"
        else -> day = "Invalid day choice"
    }
    println(day)
}







