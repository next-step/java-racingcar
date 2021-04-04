package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.command.NumberType;
import racingcar.utils.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @DisplayName("0~9사이의 값을 사용하는가?")
    @Test
    void random_test() {
        int number = RandomNumber.random();
        assertThat(number).isGreaterThan(NumberType.ZERO.value()).isLessThan(NumberType.TEN.value());
    }
}
