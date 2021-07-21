package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest(name = "{displayName} / value = {0}")
    @CsvSource(value = {"a:1", "a,b:2", "a,b,c:3", "a,b,c,d:4", "a,b,c,d,e:5"}, delimiter = ':')
    @DisplayName("CarGroup 사이즈 테스트")
    public void CarGroupSize(String names, int expected) {
        //given
        Cars cars = Cars.of(names);

        //when, then
        assertThat(cars.countOfCars()).isEqualTo(expected);
    }
}
