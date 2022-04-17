package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameMoveCounterTest {
    private RacingGameMoveCounter racingGameMoveCounter;

    @BeforeEach
    void setUp() {
        this.racingGameMoveCounter = new RacingGameMoveCounter(2);
    }

    @Nested
    class isSameOrBiggerThen_메서드는 {

        @Nested
        class 같거나_작은값이_주어질_경우 {

            @ParameterizedTest
            @ValueSource(ints = {1, 2})
            void true를_리턴한다(final int number) {
                final boolean actual = racingGameMoveCounter.isSameOrBiggerThen(number);

                assertThat(actual).isTrue();
            }
        }

        @Nested
        class 큰값이_주어질_경우 {

            @ParameterizedTest
            @ValueSource(ints = {3})
            void false를_리턴한다(final int number) {
                final boolean actual = racingGameMoveCounter.isSameOrBiggerThen(number);

                assertThat(actual).isFalse();
            }
        }
    }
}
