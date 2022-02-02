package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.vo.Car;

public class RacingTest {

    @DisplayName("Racing_drive_메소드_테스트")
    @ParameterizedTest
    @CsvSource({"a,aa,aaa"})
    void driveTest(String one, String two, String three) {
        final List<Car> cars = Arrays.asList(new Car(one), new Car(two), new Car(three));
        Racing racing = new Racing(cars, new FixMoveBehavior(true));
        racing.drive();
        assertAll(
            () -> assertThat(cars.get(0).getStep()).isEqualTo(1),
            () -> assertThat(cars.get(1).getStep()).isEqualTo(1),
            () -> assertThat(cars.get(2).getStep()).isEqualTo(1)
        );
    }
}
