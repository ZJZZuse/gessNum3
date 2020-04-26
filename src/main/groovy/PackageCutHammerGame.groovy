import myLib.MyCommonToolsZ

import java.text.SimpleDateFormat

/**
 * Created on 2015/11/23.
 *
 * 构造，play即可
 *
 */
class PackageCutHammerGame {


    def callback = { r, cupType -> }
    def player = 'playerD'

    def score = 0

    def continuousWinCount = 0
    def maxContinuousWinCount = 0
    def maxContinuousWinCountCreateTime = null

    def cupType

    def gameTimes = 0

    def reuslt

    def cupTypes = [PackageCutHammerGameType.PACK, PackageCutHammerGameType.SCISSORS, PackageCutHammerGameType.HAMMER]


    public static enum PackageCutHammerGameType
    {

        PACK(1), SCISSORS(2), HAMMER(3)

        def value = 0

        PackageCutHammerGameType(n) {

            value = n

        }


    }

    public static enum PackageCutHammerGameResult {

        WIN, LOSE, DRAW

    }

    def play(PackageCutHammerGameType type) {

        gameTimes++

        cupType = getCupTypeT()

        if (type == cupType) {
            callbackPri(PackageCutHammerGameResult.DRAW)
            return
        }

        switch (type) {

            case PackageCutHammerGameType.PACK:

                if (cupType == PackageCutHammerGameType.SCISSORS) {

                    callbackPri(PackageCutHammerGameResult.LOSE)

                } else {

                    callbackPri(PackageCutHammerGameResult.WIN)

                }

                break
            case PackageCutHammerGameType.SCISSORS:
                if (cupType == PackageCutHammerGameType.HAMMER) {

                    callbackPri(PackageCutHammerGameResult.LOSE)

                } else {

                    callbackPri(PackageCutHammerGameResult.WIN)

                }
                break
            case PackageCutHammerGameType.HAMMER:
                if (cupType == PackageCutHammerGameType.PACK) {

                    callbackPri(PackageCutHammerGameResult.LOSE)

                } else {

                    callbackPri(PackageCutHammerGameResult.WIN)

                }
                break

        }


    }

    private callbackPri(type) {

        reuslt = type

        switch (type) {

            case PackageCutHammerGameResult.WIN:


                score += (continuousWinCount++ * 1)

                if (continuousWinCount > maxContinuousWinCount) {

                    maxContinuousWinCount = continuousWinCount
                    maxContinuousWinCountCreateTime = new Date()

                }

                break
            case PackageCutHammerGameResult.LOSE:

                continuousWinCount = 0
                score--
                break

        }

        callback(type)
    }

    def getCupTypeT() {

        cupTypes[MyCommonToolsZ.randomInt(2)]
    }

    @Override
    String toString() {

        SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")

        def t = "$player,$score,$maxContinuousWinCount,$gameTimes,$cupType,$reuslt,"

        if (maxContinuousWinCountCreateTime != null) {

            return t + f.format(maxContinuousWinCountCreateTime)

        }

        t
    }
}
