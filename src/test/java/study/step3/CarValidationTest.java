package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.StringValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarValidationTest {
    @Test
    @DisplayName("자동차 이름을 ,로 구분하는 테스트")
    void 자동차이름_구분(){
        String carNames = "pobi,crong,honux";
        String[] result = carNames.split(StringValidator.CAR_NAME_SPLIT_DELIMITER);
        assertThat(result).hasSize(3).contains("pobi","crong","honux");
    }

    @Test
    @DisplayName("자동차 이름 길이 체크 테스트")
    void 자동차이름_길이체크(){
        String carName = "honux23";
        assertThat(carName.length() > StringValidator.CAR_NAME_LENGTH_LIMIT).isTrue();
    }

}
