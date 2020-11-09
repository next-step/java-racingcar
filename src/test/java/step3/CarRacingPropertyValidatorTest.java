package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingPropertyValidatorTest {

    CarRacingPropertyValidator validator;

    @BeforeEach
    void setUp(){
        validator = new CarRacingPropertyValidator();
    }

    @ParameterizedTest
    @DisplayName("1 이상의 정수만 Number 프로퍼티다")
    @ValueSource(strings = {"10", "1000"})
    void isNumber_1(String value){
        assertThat(validator.isNumber(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("음수는 Number 프로퍼티가 아니다")
    @ValueSource(strings = {"-1", "-100", "-1000"})
    void isNumber_2(String value){
        assertThat(validator.isNumber(value)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("0은 Number 프로퍼티가 아니다")
    @ValueSource(strings = {"10", "1000"})
    void isNumber_3(String value){
        assertThat(validator.isNumber(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("숫자이외에 문자는 Number 프로퍼티가 아니다")
    @ValueSource(strings = {"abc", "hundred", "#1"})
    void isNumber_4(String value){
        assertThat(validator.isNumber(value)).isFalse();
    }

}