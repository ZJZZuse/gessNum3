import myLib.MyCommonToolsZ

/**
 * Created by wb-zhangjinzhong on 2015/12/1.
 */
class SimpleBlackJack extends MySimpleGameBase {

    int points = 0

    int thisGamePoint = 0

    int thisScore = 0

    def initData() {

        score = 100
        newGame()
    }

    static enum PlayerInput {

        GAIN, SHOW

    }

    def newGame() {

        points = 0
        cupInput = MyCommonToolsZ.randomInt(1, 21)

    }


    @Override
    def certainPlay(Object input) {

        //只有新游戏时的押注有效
        if (result == null || result == MySimpleGameBase.Result.WIN || result == MySimpleGameBase.Result.LOSE || result == MySimpleGameBase.Result.NO_ENOUGH_SCORE) {

            newGame()
            thisScore = input[1]

            if (thisScore > score) {

                return MySimpleGameBase.Result.NO_ENOUGH_SCORE

            }
        }

        if (input[0] == PlayerInput.GAIN) {

            thisGamePoint = MyCommonToolsZ.randomInt(1, 10)

            if (points + thisGamePoint > 21) {

                return MySimpleGameBase.Result.LOSE
            }

            points += thisGamePoint

            return MySimpleGameBase.Result.CONTINUE
        } else {

            if (points > cupInput) {

                return MySimpleGameBase.Result.WIN

            } else if (points < cupInput) {

                return MySimpleGameBase.Result.LOSE

            } else {

                return MySimpleGameBase.Result.DRAW

            }

        }

    }

    @Override
    def certainPlayResult(Object result) {

        switch (result) {

            case MySimpleGameBase.Result.WIN:
                score += thisScore
                break
            case MySimpleGameBase.Result.LOSE:
                score -= thisScore
                break
            case MySimpleGameBase.Result.DRAW:

                break
        }

    }

    @Override
    String toString() {

        return super.toString() + " - points=$points,thisGamePoint=$thisGamePoint, cupInput=$cupInput"
    }
}
