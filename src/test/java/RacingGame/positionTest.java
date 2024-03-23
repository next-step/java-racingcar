package RacingGame;

import RacingGame.model.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class positionTest {
    @ParameterizedTest(name = "{0}값의 Position 반환 값은 {0} 이다")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void generatePosition(int number) {
        Position position = Position.valueOf(number);

        Assertions.assertThat(position.getPosition()).isEqualTo(number);
    }

    @ParameterizedTest(name = "{0}값의 Position 1회 increase 한 값은 {1} 이다")
    @CsvSource(value = {"1:2", "2:3", "3:4", "4:5", "5:6"}, delimiter = ':')
    void increasePosition(int number, int expected) {
        Position position = Position.valueOf(number);
        position = position.increase();

        Assertions.assertThat(position.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}값의 Position 값을 {0} 정수를 비교하면 값은 True 이다")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void equalPosition(int number) {
        Position position = Position.valueOf(number);

        Assertions.assertThat(position.isValueEquals(number)).isTrue();
    }
}
