package com.seq.perfectnumber.actors

import scala.actors.Actor._

class PerfectUtilScala {

  def isPerfect(candidate: Int) = {
    val RANGE = 10000000
    val numberOfPartitions = (candidate.toDouble / RANGE).ceil.toInt
    val caller = self
    
    
    val sumoffactorsActor1 = actor{
    	loop {
    		react {
				case msg:FactorsRangeForCandidate =>
					caller ! sumOfFactorsInRange(msg.lower, msg.upper, msg.candidate)
			}		
		}	
    }

    val sumoffactorsActor2 = actor{
    	loop {
    		react {
				case msg:FactorsRangeForCandidate =>
					caller ! sumOfFactorsInRange(msg.lower, msg.upper, msg.candidate)
			}		
		}	
    }
    val sumArr = List(sumoffactorsActor1, sumoffactorsActor2)
    for (i <- 0 until numberOfPartitions) {
      val lower = i * RANGE + 1;
      val upper = candidate min (i + 1) * RANGE
      
      sumArr(i%2) ! new FactorsRangeForCandidate(lower, upper, candidate)
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


class FactorsRangeForCandidate(val lower:Int, val upper:Int, val candidate:Int)