package org.bk.perfectnumber.future

import scala.actors.Actor._
import scala.actors.Futures.future

class PerfectUtilWithFutureScala {

  def isPerfect(candidate: Int) = {
    val RANGE = 10000000
    val numberOfPartitions = (candidate.toDouble / RANGE).ceil.toInt
    val caller = self
 
    for (i <- 0 until numberOfPartitions) {
      val lower = i * RANGE + 1;
      val upper = candidate min (i + 1) * RANGE
      //println("Submitted for " + lower)
	  future{caller ! sumOfFactorsInRange(lower, upper, candidate)}	
    }

    val sum = (0 /: (0 until numberOfPartitions)) { (partialSum, i) =>
      receive {
        case sumInRange: Int => partialSum + sumInRange
      }
    }

    2 * candidate == sum
  }

  private def sumOfFactorsInRange(lower: Int, upper: Int, number: Int) = {
    (0 /: (lower to upper)) { (sum, i) => if (number % i == 0) sum + i else sum }
  }

}
