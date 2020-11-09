package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingNumberPropertyValidatorTest {

    CarRacingNumberPropertyValidator validator;

    @BeforeEach
    void setUp(){
        validator = new CarRacingNumberPropertyValidator();
    }

    @ParameterizedTest
    @DisplayName("1 이상의 정수만 Number 프로퍼티다")
    @ValueSource(strings = {"10", "1000"})
    void restriction1(String value){
        assertThat(validator.validate(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("음수는 Number 프로퍼티가 아니다")
    @ValueSource(strings = {"-1", "-100", "-1000"})
    void restriction2(String value){
        assertThat(validator.validate(value)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("0은 Number 프로퍼티가 아니다")
    @ValueSource(strings = {"10", "1000"})
    void restriction3(String value){
        assertThat(validator.validate(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("숫자이외에 문자는 Number 프로퍼티가 아니다")
    @ValueSource(strings = {"abc", "hundred", "#1"})
    void restriction4(String value){
        assertThat(validator.validate(value)).isFalse();
    }

}