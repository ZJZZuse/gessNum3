package myLib

/**
 * Created on 2015/12/1.
 */
class MyNoRepeatRandomInt {

    static enum Result{

        NO_NEXT

    }

    int min = 0
    int max = 100

    boolean continueAuto = true

    def nums = []

    def iMain = 0


    def sizeM

    MyNoRepeatRandomInt() {

        initData()

    }

    /**
     * 但序列生成完时可以继续调用
     */
    void initData() {

        iMain = 0

        for (i in min..max) {

            nums.add(i)

        }

        Collections.shuffle(nums)

        sizeM = max - min + 1
    }

    def next() {

        if (iMain >= sizeM) {

            if (continueAuto){

                initData()

            }

            return Result.NO_NEXT

        }


        nums[iMain++]
    }

}
