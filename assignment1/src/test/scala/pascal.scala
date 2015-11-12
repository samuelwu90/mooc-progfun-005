package assignment1


import Main._

class PascalSpecification extends org.specs2.mutable.Specification {

    "mooc-progfun-004 / assignment 1 / problem 1" >> {

        "where the tuples should evaluate to pascal's triangle" >> {

            """
                (0,0),
                (0,1), (1,1),
                (0,2), (1,2), (2,2),
                (0,3), (1,3), (2,3), (3,3),
                (0,4), (1,4), (2,4), (3,4), (4,4))

                should evaluate to:

                1,
                1, 1,
                1, 2, 1,
                1, 3, 3, 1,
                1, 4, 6, 4, 1)""" >> {

                var coordinates = List( (0,0),
                                                    (0,1), (1,1),
                                                    (0,2), (1,2), (2,2),
                                                    (0,3), (1,3), (2,3), (3,3),
                                                    (0,4), (1,4), (2,4), (3,4), (4,4))

                var expected = List(  1,
                                                1, 1,
                                                1, 2, 1,
                                                1, 3, 3, 1,
                                                1, 4, 6, 4, 1)

                var output = coordinates.map { tuple =>
                    val (col, row) = tuple
                    pascal(col, row)

                }

                output must_== expected
            }

        }

        "where the assignment example cases should pass" >> {
            "pascal(0,2) should equal 1" >> {
                pascal(0, 2) must_== 1
            }

            "pascal(0,2) should equal 2" >> {
                pascal(1, 2) must_== 2
            }

            "pascal(0,2) should equal 3" >> {
                pascal(1, 3) must_== 3
            }

        }

  }


}
