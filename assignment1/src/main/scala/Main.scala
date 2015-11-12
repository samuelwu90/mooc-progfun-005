package assignment1

import scala.collection.mutable.Stack


object Main {

    def pascal(c: Int, r: Int): Int = {
        if (c == 0 || c == r ) 1
        else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

    def balance(chars: List[Char]): Boolean = {

        def isLeftBracket (bracket: Char): Boolean = {
            return Array('(', '[', '{') contains bracket
        }

        def isRightBracket (bracket: Char): Boolean = {
            return Array( ')', ']', '}' ) contains bracket
        }

        def isMatch (leftBracket: Char, rightBracket:Char): Boolean = {
            return Map[Char, Char](
                '(' -> ')',
                '[' -> ']',
                '{' -> '}'
            )(leftBracket) == rightBracket
        }

        def inspect(chars: List[Char], parentheses: Stack[Char]): Boolean = {

            if( chars.isEmpty ){
                if (parentheses.isEmpty) true
                else false
            } else {
                if (isLeftBracket(chars.head)){
                    return inspect(chars.tail, parentheses.push(chars.head))
                } else if (isRightBracket(chars.head)){
                    if ( parentheses.isEmpty || !isMatch(parentheses.last, chars.head) ){
                        return false
                    } else {
                        return inspect(chars.tail, parentheses.tail)
                    }
                } else {
                    return inspect(chars.tail, parentheses)
                }

                return inspect(chars.tail, parentheses)

            }
        }

        return inspect(chars, Stack[Char]())
    }

    def countChange(money: Int, coins: List[Int]): Int = {

        def recurse (money: Int, coins: List[Int]): Int = {
            if (money == 0)                          return 1
            else if (money < 0 || coins.isEmpty )    return 0
            else return recurse ( money, coins.tail ) + recurse ( money - coins.head, coins )
        }

        return recurse(money, coins)

    }

}
