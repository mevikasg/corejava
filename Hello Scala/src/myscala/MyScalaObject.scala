/**
 *
 */
package myscala

import scala.collection.immutable.HashMap

/**
 * @author vikasg
 *
 */
object MyScalaObject {

  def main(args: Array[String]): Unit = {
    
    println("Hello Scala ! ");       
    
    new myCollections().myFuncitons
    
  }

}


class myCollections{
  
  def myFuncitons{
    
    println("Test My function call ()")
    
    val myList = List("myName", "is", "Vikas", "Gupta", Array(1, 2, 3, 4, 5))
    
    println(myList.toString)
    
    
    
  }
}