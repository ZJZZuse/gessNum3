import myLib.MyCommonToolsZ

/**
 * Created by wb-zhangjinzhong on 2015/11/24.
 */
class SicBoGame extends MySimpleGameBase {


    @Override
    protected initData() {
        score = 100
    }

    @Override
    def certainPlay(Object input) {

        if (input[1] > score) {

            return MySimpleGameBase.Result.NO_ENOUGH_SCORE
        }

        cupInput = MyCommonToolsZ.randomBoolean()

        def r = input[0] == cupInput

        if (r) {

            score += input[1]

        } else {
            score -= input[1]
        }

        return r
    }


}
