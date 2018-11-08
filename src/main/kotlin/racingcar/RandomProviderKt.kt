package racingcar

import java.util.*

class RandomProviderKt {

    fun getRandom(): Int = Random().nextInt(RANDOM_MAX_SIZE)

    companion object {
        private const val RANDOM_MAX_SIZE = 10
    }
}
