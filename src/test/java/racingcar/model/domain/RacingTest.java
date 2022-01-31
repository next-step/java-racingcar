package racingcar.model.domain;

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
        Racing racing = new Racing(cars, new FixNumberBehavior(true));
        racing.drive();
    }
}
