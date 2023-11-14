package step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @Test
    void moveTest() {
        NumberGenerator numberGenerator = new MovableNumberGenerator();

        RacingCar racingCar = new RacingCar("test");
        assertThat(racingCar.getDistance()).isEqualTo(0);

        racingCar.move(numberGenerator);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @Test
    void nonMoveTest() {
        NumberGenerator numberGenerator = new NonMovableNumberGenerator();

        RacingCar racingCar = new RacingCar("test");
        assertThat(racingCar.getDistance()).isEqualTo(0);

        racingCar.move(numberGenerator);
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car", "car5자"})
    void correctNameTest(String correctName) {
        RacingCar racingCar = new RacingCar(correctName);
        assertThat(racingCar.name().value()).isEqualTo(correctName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"racing", "racingCar"})
    void incorrectNameTest_이름_5자_초과(String incorrectName) {
        assertThatThrownBy(() -> {
            RacingCar racingCar = new RacingCar(incorrectName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matchDistanceTest() {
        RacingCar test1 = new RacingCar("test1", 3);
        RacingCar test2 = new RacingCar("test2", 3);
        assertThat(test1.matchDistance(test2)).isTrue();
    }

    @Test
    void getFasterTest() {
        RacingCar faster = new RacingCar("fast", 5);
        RacingCar slower = new RacingCar("slow", 1);
        assertThat(faster.getFaster(slower)).isEqualTo(faster);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,---", "4,----"})
    void drawDistanceTest(int distance, String expected) {
        RacingCar racingCar = new RacingCar("test", distance);
        assertThat(racingCar.drawDistance()).isEqualTo(expected);
    }

    private class MovableNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 4;
        }
    }

    private class NonMovableNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 3;
        }
    }

}