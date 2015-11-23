import java.text.SimpleDateFormat

/**
 * Created by wb-zhangjinzhong on 2015/11/23.
 *
 * 
 *
 */

abstract class MySimpleGameBase {

    static enum Result {
        WIN(1), LOSE(2), DRAW(3)

        def value = 0

        Result(v) {

            value = v

        }
    }

    static enum PlayerInput {

    }

    def player = 'playerD'

    /**
     * 用户传入，实现界面等功能
     * r,this
     */
    def callback = { r, t ->

    }

    def score = 0
    def maxScore = 0
    def maxScoreCreateTime = null

    def playTimes = 0

    def playerInput
    def result

    def play(p = null) {

        playerInput = p

        result = certainPlay(p)
        playResult(result)
    }

    /**
     * 实现分数，其他参数的游戏逻辑，一次游戏
     * @return
     */
    abstract certainPlay(input)

    def playResult(result) {

        playTimes++

        if (score > maxScore) {

            maxScore = score
            maxScoreCreateTime = new Date()

        }

        callback(result, this)

    }

    @Override
    String toString() {

        if (maxScore == 0) {

            return

        }

        SimpleDateFormat f = new SimpleDateFormat('yyyy.MM.dd HH:mm:ss')

        "$player's score is $score,play times:$playTimes.$maxScore,${f.format(maxScoreCreateTime)}"

    }
}
