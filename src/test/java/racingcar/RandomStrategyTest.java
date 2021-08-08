package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyTest {
    @DisplayName("랜덤값 4 이상이면 움직일 수 있다.")
    @ParameterizedTest(name = "랜덤값 {0}: 움직일수 있다={1}")
    @CsvSource(value = {"3:false", "4:true"}, delimiter = ':')
    void randomNumMoreThan4ReturnsTrue(int randomNum, boolean movable) {
        assertThat(new RandomStrategy(randomNum).movable()).isEqualTo(movable);
    }
}
