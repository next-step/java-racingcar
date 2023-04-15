package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarFactoryTest {

    @ParameterizedTest
    @DisplayName("쉼표로 구분된 이름수 만큼 자동차를 생산한다")
    @CsvSource(value = {"짱구,철수,맹구:3", "짱구,철수:2", "짱구:1"}, delimiter = ':')
    void create(String input, int output) {
        List<Car> cars = CarFactory.create(input);

        assertThat(cars).hasSize(output);
    }
}
