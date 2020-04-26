import myLib.MyCommonToolsZ

/**
 * Created on 2015/11/17.
 */
class NumGuesser {

    int min = 0
    int max = 100

    def guessCount = 0

//    def auto = true

    int goalNum

    int nowMin = min
    int nowMax = max

    def strGoalRange = '%d-%d'

    static bestPerformance = [

            'bestGuessCount' : 1000,
            'time' : new Date(),
            'goalNum' : 0,
            'range' : '%d-%d'

    ]

    static enum Result {
        RIGHT, LOWER, HIGHER, OUT_RANGE
    }


    NumGuesser() {
        initData()
    }

//    NumGuesser(int max, int min) {
//
//        NumGuesser()
//
//        this.max = max
//        this.min = min
//    }

    def initData() {


    }

    def acqWinStr() {

        "win,guess count is ${guessCount}"

    }

    def acqLowerStr() {

        'lower,range is ' + String.format(strGoalRange, nowMin, nowMax)

    }

    def acqHigherStr() {

        'higher,range is ' + String.format(strGoalRange, nowMin, nowMax)

    }

    def acqOutRangeStr() {

        'out of range,range is ' + String.format(strGoalRange, nowMin, nowMax)

    }

    def startGame() {

        initGame()
    }

    private initGame() {
        goalNum = generateNum()
        guessCount = 0

        nowMin = min
        nowMax = max

        generateNum()

        "guess a number in ${min}-${max}"
    }

    def guess(num) {

        guessCount++

        if (num < nowMin || num > nowMax) {

            return [Result.OUT_RANGE, acqOutRangeStr()]

        }

        if (goalNum == num) {

            return [Result.RIGHT, acqWinStr()]

        }

        if (num > goalNum) {

            nowMax = num - 1

            return [Result.HIGHER, acqHigherStr()]
        } else {

            nowMin = num + 1

            return [Result.LOWER, acqLowerStr()]
        }

    }

    int generateNum() {

        goalNum = MyCommonToolsZ.randomInt(min, max)

    }
}
