package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.vehicle.Cars;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("자동차 이름 입력 테스트")
    void 자동차_이름입력_테스트(String input) {
        Cars car = new Cars(input.split(","));
        Assertions.assertThat(car).hasNoNullFieldsOrProperties();
    }



}
