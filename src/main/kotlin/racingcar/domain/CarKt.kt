package racingcar.domain

class CarKt(var name: String, var position: Int = 0) {

    fun move(randomNumber: Int): Int {
        if (randomNumber >= MOVABLE_POSITION) {
            position += 1
        }

        return position
    }

    companion object {
        private const val MOVABLE_POSITION = 4
    }
}
