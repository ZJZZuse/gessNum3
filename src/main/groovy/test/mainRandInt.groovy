package test

import myLib.MyNoRepeatRandomInt

/**
 * Created on 2015/12/1.
 */

def tc = new MyNoRepeatRandomInt()

int i = 0

while (true) {

    def t = tc.next()

    if (t == MyNoRepeatRandomInt.Result.NO_NEXT) {

        break

    }

    print("${i++}-$t,")

}