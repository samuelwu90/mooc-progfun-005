package assignment1


import Main._

class CountChangeSpecification extends org.specs2.mutable.Specification {


        "where the assignment example cases should pass" >> {
            "countChange(0, List()) should equal 3" >> {
                countChange(0, List()) must_== 1
            }

            "countChange(4, List(1,2)) should equal 3" >> {
                countChange(4, List(1,2)) must_== 3
            }

        }


}
