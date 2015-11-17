package myLib

/**
 * Created by wb-zhangjinzhong on 2015/11/17.
 */
class MyCommonToolsZ {

    static randomInt(min = 0, max) {

        def a = Math.floor(Math.random() * (max - min + 1)) + min
        (int) a
    }


}
