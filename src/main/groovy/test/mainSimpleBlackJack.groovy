package test

import myLib.MyCommonToolsZ

/**
 * Created on 2015/12/1.
 */


game = new SimpleBlackJack()

1000.times {

    def choice = SimpleBlackJack.PlayerInput.GAIN

    if (game.result == MySimpleGameBase.Result.CONTINUE && game.points > 10) {

        choice = SimpleBlackJack.PlayerInput.SHOW

    }

    game.play(choice, MyCommonToolsZ.randomInt(50))

    println(game)

}