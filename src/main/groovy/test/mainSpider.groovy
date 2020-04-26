package test

import org.jsoup.Jsoup

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingDeque
import java.util.concurrent.Executors

/**
 * Created on 2015/11/18.
 */

mainItems = new ArrayBlockingQueue<String>(3)

tp = Executors.newFixedThreadPool(2)

def main(mainItems) {


    mainUrl = 'http://jingyan.baidu.com/list/%d'

    baseUrl = 'http://jingyan.baidu.com'

    for (i in 1..3) {

        doc = Jsoup.connect(String.format(mainUrl, i)).get();

        eles = doc.select('.exp-list-cont>ul>li>a')

        for (ele in eles) {

//

            mainItems.put(baseUrl + ele.attr('href'))

        }
    }
}

def acqCertainItem(mainItems) {

    url = mainItems.take()

    doc = Jsoup.connect(String.format(mainUrl, i)).get();

    println(doc.select('#format-exp').text())

}

//tp.execute({
//
//    test.main(mainItems)
//
//})
//
//tp.execute({ acqCertainItem(mainItems) })
//
//tp.shutdown()

def fnT(){

    url = 'http://www.oschina.net/action/favorite/attentionUsersCount?id=86540&type=2'

    println Jsoup.connect(url).get()

}

fnT()