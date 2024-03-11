package racinggame.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsNamesTest {

    @Test
    void 생성자_빈값_유효성() {
        String carsNames = null;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarsNames(carsNames.split(",")))
                .withMessageMatching("자동차 이름을 입력하지 않았습니다.");
    }

    @Test
    void 생성자_이름_길이_유효성() {
        String carsNames = "abcdef";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarsNames(carsNames.split(",")))
                .withMessageMatching("자동차 이름은 5글자를 초과할 수 없습니다: \\d");
    }
}
