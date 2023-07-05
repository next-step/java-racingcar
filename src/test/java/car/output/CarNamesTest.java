package car.output;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.domain.CarNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNamesTest {
    @Test
    @DisplayName("자동차 이름이 정상적으로 입력됨")
    void 자동차_이름_테스트_정상 () {
        String carNames = "pobi,crong,honux";
        assertThatCode(()-> new CarNames(carNames)).doesNotThrowAnyException();
    }
    @ParameterizedTest
    @DisplayName("자동차 이름이 공백이나, null 같이정상적으로 입력 되지 않음")
    @ValueSource(strings = {"", " "})
    void 자동차_이름_테스트_오류(String str) {
        assertThrows(RuntimeException.class, ()-> new CarNames(str));
    }
}
