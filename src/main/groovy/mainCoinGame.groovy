import myLib.MyCommonToolsZ

/**
 * Created by wb-zhangjinzhong on 2015/11/24.
 */

game = new CoinGame()

10.times {

    r = game.play()
    println("$it,-- $game")
    println()

}
