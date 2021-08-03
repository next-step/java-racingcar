package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("입력된 차 List가 null이거나 empty일 경우 IllegalArgumentExcpetion 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @NullAndEmptySource
    void create_ThrowsIllegalArgumentException_IfCarListIsNullOrEmpty(List<Car> cars) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Cars(cars));
    }

    @DisplayName("생성")
    @Test
    void create() {
        List<Car> initCars = Arrays.asList(new Car("bmw"), new Car("audi"), new Car("benz"));
        Cars cars = new Cars(initCars);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}
