package genifer.test

import junit.framework.TestCase
import org.scalatest.junit.AssertionsForJUnit
import scala.collection.mutable.ListBuffer
import junit.framework.Assert._

class RunTests extends TestCase  {

  var sb: StringBuilder = _
  var lb: ListBuffer[String] = _

  override def setUp() {
    sb = new StringBuilder("ScalaTest is ")
    lb = new ListBuffer[String]
  }

  def testEasy() { // Uses JUnit-style assertions
    sb.append("easy!")
    assertEquals("ScalaTest is easy!", sb.toString)
    assertTrue(lb.isEmpty)
    lb += "sweet"
    try {
      "verbose".charAt(-1)
      fail()
    }
    catch {
      case e: StringIndexOutOfBoundsException => // Expected
    }
  }

//  def testFun() { // Uses ScalaTest assertions
//    sb.append("fun!")
//    assert(sb.toString === "ScalaTest is fun!")
//    assert(lb.isEmpty)
//    lb += "sweeter"
//    intercept[StringIndexOutOfBoundsException] {
//      "concise".charAt(-1)
//    }
//  }
}