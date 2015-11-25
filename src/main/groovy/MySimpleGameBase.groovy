import java.text.SimpleDateFormat

/**
 * Created by wb-zhangjinzhong on 2015/11/23.
 *
 *
 *
 */

abstract class MySimpleGameBase {

    /**
     * 游戏结果
     */
    static enum Result {
        WIN(1), LOSE(2), DRAW(3),NO_ENOUGH_SCORE(4)

        def value = 0

        Result(v) {

            value = v

        }
    }

    /**
     * 输入
     */
    static enum PlayerInput {

    }

    /**
     * 游戏者
     */
    protected player = 'playerD'

    /**
     * 用户传入，实现界面等功能
     * r,this
     */
    protected callback = { r, t ->

    }

    protected score = 0
    protected maxScore = 0
    protected maxScoreCreateTime = null

    protected playTimes = 0

    def cupInput
    protected playerInput
    protected result

    MySimpleGameBase(){

        initData()

    }

    protected initData(){}

    def play(def ... p) {

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

        certainPlayResult(result)

        playTimes++

        if (score > maxScore) {

            maxScore = score
            maxScoreCreateTime = new Date()

        }

        callback(result, this)

        return result
    }

    def certainPlayResult(result) {}

    @Override
    String toString() {

        def baseStr = "$player's input is $playerInput, result is $result. Now score is $score,play times:$playTimes,max score:$maxScore"

        if (maxScore == 0) {


            return baseStr

        }

        SimpleDateFormat f = new SimpleDateFormat('yyyy.MM.dd HH:mm:ss')

        "$baseStr,${f.format(maxScoreCreateTime)}"

    }
}
