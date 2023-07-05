package car.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @Test
    @DisplayName("자동차 입력이 정상적인지 확인")
    void 자동차_이름_테스트_정상() {
        String carName = "pobi";
        assertThatCode(() -> new Car(carName)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 입력이 5자 글자 초과로 오류")
    void 자동차_이름_테스트_5자글자_초과_오류() {
        String carName = "pobiii";
        assertThrows(RuntimeException.class, () -> new Car(carName));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"aaaaa,aaaaaa"})
    @DisplayName("자동차 이름 5자 초과 예외 처리")
    void 자동차_이름_5자_초과(String str) {
        assertThrows(RuntimeException.class, () -> new Cars(new CarNames(str)));
    }
}
