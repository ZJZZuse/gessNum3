package myLib

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created on 2015/11/18.
 */
class MySpiderUrl implements Iterable {

    def baseUrl = ''

    def specailMainUrls = []
//            ele as {'url': '', 'range': range(1,3 + 1)},
    def mainUrls = []

    private urlT = ''

    private queueT =new ArrayBlockingQueue(1)

    private AtomicBoolean finish = false

    @Override
    Iterator iterator() {

        def pool = Executors.newSingleThreadExecutor()

        pool.execute({

            getNextMainUrl()

        })

        pool.shutdown()

        return new Iterator() {

            @Override
            boolean hasNext() {
                return !finish
            }

            @Override
            Object next() {
               queueT.take()
            }
        }
    }

    private getNextMainUrl() {

        for (ele in specailMainUrls) {

            queueT.put(ele)

        }

        for (ele in mainUrls) {

            for (i in ele.range) {

                urlT = String.format(ele, i)
                queueT.put(urlT)

            }

        }

        finish = true

    }

}
