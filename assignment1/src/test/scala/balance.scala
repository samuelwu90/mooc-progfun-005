package assignment1


import Main._


class BalanceSpecification extends org.specs2.mutable.Specification {

  "mooc-progfun-004 / assignment 1 / problem 2" >> {

    "where () brackets must be handled correctly" >> {
        " '()' should evaluate to true" >> {
            balance("()".toList) must_== true
        }
        " ')(' should evaluate to false" >> {
            balance(")(".toList) must_== false
        }
    }

    "where [] brackets must be handled correctly" >> {
        " '[]' should evaluate to true" >> {
            balance("[]".toList) must_== true
        }
        " ')(' should evaluate to false" >> {
            balance("][".toList) must_== false
        }
    }

    "where {} brackets must be handled correctly" >> {
        " '{}' should evaluate to true" >> {
            balance("{}".toList) must_== true
        }
        " '}{' should evaluate to false" >> {
            balance("}{".toList) must_== false
        }
    }

    "where the assignment example cases should pass" >> {
        "'(if (zero? x) max (/ 1 x))' should evaluate to true" >> {
            balance("(if (zero? x) max (/ 1 x))".toList) must_== true
        }

        "'I told him (that it’s not (yet) done). (But he wasn’t listening)' should evaluate to true" >> {
            balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList) must_== true
        }

        "':-)' should evaluate to false" >> {
            balance(":-)".toList) must_== false
        }

        "'())(' should evaluate to false" >> {
            balance("())(".toList) must_== false
        }
    }

  }
}
