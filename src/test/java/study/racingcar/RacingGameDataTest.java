package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import study.racingcar.domain.Car;
import study.racingcar.domain.RacingGameData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingGameDataTest {
    @DisplayName("시도 횟수는 1 이상이여야 한다.")
    @Test
    void timeMustBeGreaterThenOne() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new RacingGameData(Arrays.asList("luvram"), 0);
                }).withMessage("시도 횟수는 1 이상이여야 합니다.");
    }

    @DisplayName("차는 한대 이상이여야 한다.")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void carMustBeGreaterThenOne(List<String> cars) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new RacingGameData(cars, 1);
                });
    }

    @DisplayName("차의 이름으로 초기화가 되어야 한다.")
    @Test
    void initCarWithName() {
        String testName = "luvram";
        List<String> carNames = Collections.singletonList("luvram");
        RacingGameData racingGameData = new RacingGameData(carNames, 1);
        List<Car> cars = racingGameData.getCars();
        assertThat(cars.get(0).getName()).isEqualTo(testName);
    }
}
