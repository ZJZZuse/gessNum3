package myLib

import java.util.concurrent.ArrayBlockingQueue

/**
 * Created by wb-zhangjinzhong on 2015/11/18.
 */
class MySpiderBase {

    def mySpiderUrlCfg = [

            'baseUrl'        : '',

            'specailMainUrls': [],
//            ele as {'url': '', 'range': range(1,3 + 1)},
            'mainUrls'       : []

    ]


    def mainTCount = 1
    def certainTCount = 2
    def saveTCount = 2

    def mainItems = new ArrayBlockingQueue(50)
    def certainItems = new ArrayBlockingQueue(50)

    def mainIsDone = False
    def acqCertainItemsIsDone = False

    MySpiderUrl mySpiderUrl

    def initDate(){

        mySpiderUrl = new MySpiderUrl(mySpiderUrlCfg)

    }

}
