package com.seq.perfectnumber.actors

import scala.actors.Actor._
import org.junit.Assert._
import org.junit.Test

class TestPerfectUtilScala {

  val pUtil = new PerfectUtilScala
  @Test
  def testAMoreInvolvedCase1() {
    assertEquals(1, countPerfectNumbersInRange(33550300, 33550400))
  }

  def countPerfectNumbersInRange(start: Int, end: Int): Int = {
    val startTime = System.nanoTime()
    val numberOfPerfectNumbers = (0 /: (start to end)) { (count, candidate) =>
      if (pUtil.isPerfect(candidate)) count + 1 else count
    }
    
    val endTime = System.nanoTime()
    println("Scala - Actor : " + (endTime - startTime) / 1000000000.0 + " secs")
    return numberOfPerfectNumbers;
  }
  

}