package myLib

/**
 * Created by wb-zhangjinzhong on 2015/11/17.
 */
class MyCommonToolsZ {

    static randomBoolean(){

        randomInt(1) == 1

    }

    static randomInt(min = 0, max) {

        def a = Math.rint(Math.random() * (max - min + 1)) + min

        (int) a
    }

    static randomInts(min = 0, max = 100, counts = 2) {

        def nums = []

        counts.times {

            nums.push(randomInt(min, max))

        }

        nums

    }

}
