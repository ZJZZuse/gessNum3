import myLib.MyCommonToolsZ

/**
 * Created on 2015/11/23.
 */
class CoinGame extends MySimpleGameBase {


    @Override
    def certainPlayResult(p) {

        if (p) {
            score++
        } else {

            score--

        }

    }


    @Override
    def certainPlay(Object input) {


        def r = MyCommonToolsZ.randomInt(1) == 1


    }


}
