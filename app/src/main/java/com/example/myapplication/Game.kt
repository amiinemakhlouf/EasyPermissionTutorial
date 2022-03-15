package com.example.myapplication

import java.util.*
import kotlin.collections.ArrayList

class Game
{
   public var team1 = FootballTeam()
    val team2= FootballTeam()

}

open class FootballTeam (){

       var matchPlayed=0;private set

    fun play(){

        matchPlayed ++
    }


}
class HandBallTeam():FootballTeam(){


}
fun myFunction():String{

    return  "tunisia"
}

fun main(args: Array<String>) {

    val list:ArrayList<Number> = ArrayList<Number>()
    list.add(2)
    list.add(5)
    list.add(52)
    list.forEach {
            number -> println(number)

    }




}



