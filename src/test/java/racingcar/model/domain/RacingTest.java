package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingTest {

    @DisplayName("Racing_drive_메소드_테스트")
    @ParameterizedTest
    @CsvSource({"a,aa,aaa"})
    void driveTest(String one, String two, String three) {
        final Cars cars = new Cars(Arrays.asList(one, two, three));
        Racing racing = new Racing(cars, new FixMoveBehavior(true));
        racing.drive();
        assertAll(
            () -> assertThat(cars.cars().get(0).getStep()).isEqualTo(1),
            () -> assertThat(cars.cars().get(1).getStep()).isEqualTo(1),
            () -> assertThat(cars.cars().get(2).getStep()).isEqualTo(1)
        );
    }
}
