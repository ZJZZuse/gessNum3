package truthordare

/**
 * Created by wb-zhangjinzhong on 2015/12/1.
 */
class TruthOrDareManager {

    static enum TypeT {

        TRUTH, DARE, All

    }

    def truthOrDares = []


    def truths = []
    def dares = []

    def indexes = [

            all: 0,
            t  : 0,
            d  : 0

    ]

    TruthOrDareManager() {

        initData()

    }

    /**
     * 可以重置数组复用对象
     * @return
     */
    private Iterable initData(truthOrDares = this.truthOrDares) {

        truthOrDares.each {

            if (it.type == TruthOrDare.Type.DARE) {

                dares.push(it)

            } else {

                truths.push(it)

            }

        }

        shuffle()
    }

    private void shuffle() {
        Collections.shuffle(truthOrDares)
        Collections.shuffle(truths)
        Collections.shuffle(dares)

        indexes.all = 0
        indexes.t = 0
        indexes.d = 0
    }

    def next(TypeT type = TypeT.All) {

        if (indexes.all >= truthOrDares.size() || indexes.t >= truths.size() || indexes.d >= dares.size()) {

            shuffle()

        }

        switch (type) {

            case TypeT.All:
                return truthOrDares[indexes.all++]
                break

            case TypeT.DARE:
                return dares[indexes.d++]
                break

            case TypeT.TRUTH:
                return truths[indexes.t++]
                break


        }

    }

}
