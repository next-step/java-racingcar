package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.vo.Car;

public class FixNumberBehaviorTest {

    @DisplayName("랜덤넘버가_4이상일_때_전진할_수_있는지_검증")
    @ParameterizedTest
    @CsvSource({"a,aa,aaa"})
    void fixRandomNumberTest(final String one, final String two, final String three) {
        final List<Car> cars = Arrays.asList(new Car(one), new Car(two), new Car(three));
        final Racing racing = new Racing(cars, new FixNumberBehavior(true));
        racing.drive();
        racing.drive();
        assertAll(
            () -> assertThat(cars.get(0).getStep()).isEqualTo(2),
            () -> assertThat(cars.get(1).getStep()).isEqualTo(2),
            () -> assertThat(cars.get(2).getStep()).isEqualTo(2)
        );
    }
}
