package funsets

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

import FunSets._

@RunWith(classOf[JUnitRunner])
class FunSetTest extends FunSuite {

  test("Set") {
    var s = Set(1)
    assert(s(1) == true)
    assert(s(2) == false)
  }

  test("contains") {
    var s = Set(1)
    assert(contains(s, 1) == true)
    assert(contains(s, 2) == false)
  }

  test("singletonSet") {
    assert(singletonSet(1)(1) == true)
    assert(singletonSet(1)(2) == false)
  }

  test("union") {
    assert( union(Set(1), Set(2))(1) == true)
    assert( union(Set(1), Set(2))(2) == true)
    assert( union(Set(1), Set(2))(3) == false)
  }

  test("intersect") {
    assert( intersect(Set(1,2), Set(1,3))(1) == true)
    assert( intersect(Set(1,2), Set(1,3))(2) == false)
  }

  test("diff") {
    assert( diff(Set(1,2), Set(1,3))(1) == false)
    assert( diff(Set(1,2), Set(1,3))(2) == true)
  }

  test("filter") {
    assert( filter(Set(1,2,3), x => x > 1)(1) == false)
    assert( filter(Set(1,2,3), x => x > 1)(2) == true)
    assert( filter(Set(1,2,3), x => x > 1)(3) == true)
  }

  test("forall") {
    assert( forall(Set(-500,0,500), x => x > 1) == false )
    assert( forall(Set(-500,0,500), x => x > -1000) == true )
  }

  test("exists") {
    assert( exists(Set(-500,0,500), x => x > 1000) == false )
    assert( exists(Set(-500,0,500), x => x > 1) == true )
    assert( exists(Set(-500,0,500), x => x > -1000) == true )
  }

  test("map") {
    assert( map(Set(1,2,3), x => x * 2)(2) == true )
    assert( map(Set(1,2,3), x => x * 2)(4) == true )
    assert( map(Set(1,2,3), x => x * 2)(6) == true )
  }


}
