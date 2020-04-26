package test

import myLib.MyCommonToolsZ

/**
 * Created on 2015/11/17.
 */

game = new NumGuesser()

for( i in (1..100)){

    Scanner sc = new Scanner(System.in);
    println game.startGame()

    while (true) {

        int n = sc.nextInt()
        r = game.guess(n)

        println(r[1])

        if (r[0] == NumGuesser.Result.RIGHT){
            break
        }

    }

}