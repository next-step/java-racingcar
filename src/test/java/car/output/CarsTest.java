package car.output;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.domain.CarNames;
import car.domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @Test
    @DisplayName("자동차 리스트 정상 동작")
    void 자동차_리스트_정상_동작 () {
        String carNames = "pobi,crong,honux";
        assertThatCode(()-> new CarNames(carNames)).doesNotThrowAnyException();
        Cars cars = new Cars(new CarNames(carNames));
        assertThat(cars.getCars()).extracting("name").containsExactly("pobi", "crong", "honux");
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaa,aaaaaa"})
    @DisplayName("자동차 이름 5자 초과 예외 처리")
    void 자동차_이름_5자_초과 (String str) {
        assertThrows(RuntimeException.class, ()-> new Cars(new CarNames(str)));
    }


}
