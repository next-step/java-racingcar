package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class RacingGameTest {

    // Test
    @DisplayName("randomless Test upper 4")
    @ParameterizedTest
    @ValueSource(ints = {5, 9, 7})
    void testRandomlessUpper(int input) {

        // ready
        final int moveCountTestValueInsteadOfRandom = input;

        // set
        Car car = new Car(new String("any"), 0, new CarMoveStrategy() {
            @Override
            public int getMoveCount() {
                return moveCountTestValueInsteadOfRandom > 4 ? 1 : 0;
            }
        });

        // test
        int before = car.getLocation();
        car.move();
        int after = car.getLocation();

        assertThat(after - before).isEqualTo(1);
    }

    @DisplayName("randomless Test under 4")
    @ParameterizedTest
    @ValueSource(ints = {4, 3, 2, 1})
    void testRandomlessUnder(int input) {

        // ready
        final int moveCountTestValueInsteadOfRandom = input;

        // set
        Car car = new Car(new String("anyTest"), 0, new CarMoveStrategy() {
            @Override
            public int getMoveCount() {
                return moveCountTestValueInsteadOfRandom > 4 ? 1 : 0;
            }
        });

        // test
        int before = car.getLocation();
        car.move();
        int after = car.getLocation();

        assertThat(after - before).isEqualTo(0);

    }


    @DisplayName("Arguments check / input negative number to cars count.")
    @ParameterizedTest
    @ValueSource(ints = {-2, -3, -1, -100})
    void testInputCarsCountNegativeNumber(int tryTimes) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    RacingGame racingGame = new RacingGame(new String[]{"any", "test"}, tryTimes);
                }
        );
    }






}
