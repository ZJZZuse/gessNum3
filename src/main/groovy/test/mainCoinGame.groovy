package test

import myLib.MyCommonToolsZ

/**
 * Created on 2015/11/24.
 */

game = new CoinGame()

10.times {

    r = game.play()
    println("$it,-- $game")
    println()

}
