package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("문자열 사칙연산 성공")
    @ParameterizedTest
    @CsvSource(value = {"hojun:1",
            "hojun,jun:2",
            "hojun,jun,dusk:3",
            "hojun,jun,dusk,task:4"},
            delimiter = ':')
    void split_inputName_success(String inputNames, int result) {
        assertThat(Car.ofCars(inputNames).size()).isEqualTo(result);
    }

    @DisplayName("자리 이동 성공")
    @ParameterizedTest
    @CsvSource(value = {"hojun:0:2:2",
            "hojun:4:1:1"},
            delimiter = ':')
    void goAhead(String name, int min, int max, int result) {
        Car a = new Car(name);
        a.goAhead(Accelerator.ofCustomAccelerator(min, max));
        assertThat(a.getLocation()).isEqualTo(result);
    }
}