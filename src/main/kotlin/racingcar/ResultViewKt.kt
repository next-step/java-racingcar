package racingcar

object ResultViewKt {
    /**
     * @param carPositions
     * 결과 출력
     */
    fun showResult(carPositions: IntArray) {
        carPositions.forEach {
            drawDash(it)
            println()
        }
    }

    /**
     * @param carPosition
     * 차량 현재 위치를 그린다.
     */
    private fun drawDash(carPosition: Int) {
        for (j in 0 until carPosition) {
            print("-")
        }
    }
}
