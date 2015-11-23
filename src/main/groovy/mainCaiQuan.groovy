/**
 * Created by wb-zhangjinzhong on 2015/11/23.
 */

game = new PackageCutHammerGame(callback: { r ->

    switch (r) {

        case PackageCutHammerGame.PackageCutHammerGameResult.WIN:
            println('win')
            break
        case PackageCutHammerGame.PackageCutHammerGameResult.LOSE:
            println('lose')
            break
        default:
            println('draw')
            break

    }


})

game.setPlayer('ming')

100.times {

    game.play(game.getCupTypeT())
    println("$it:${game}")
    println()

}