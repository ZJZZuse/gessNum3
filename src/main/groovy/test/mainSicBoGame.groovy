package test

import static myLib.MyCommonToolsZ.*

/**
 * Created on 2015/11/24.
 */

game = new SicBoGame()

10.times {

    game.play(randomBoolean(),randomInt(100))
    println("$it $game")


}

