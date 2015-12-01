import junit.framework.TestCase
import myLib.MyNoRepeatRandomInt
import org.junit.Test

/**
 * Created by wb-zhangjinzhong on 2015/12/1.
 */
class TestRand1 {

//    @Test
    def static void testMain() {

        def tc = new MyNoRepeatRandomInt()

        while (true) {

            def t = tc.next()

            if (!t) {

                return

            }

            print("$t,")

        }

    }

    public static void main(){

        testMain()

    }
}
