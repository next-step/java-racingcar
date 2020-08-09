package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNamesTest {
    @DisplayName("이름문자열을 받아서 CarName List를 가진 1급 컬랙션 생성")
    @Test
    void newCarNamesWithStringValue() {
        //given
        String nameValue = "1,2,3,4";
        int expectedSize = 4;

        //when
        CarNames carNames = CarNames.newInstance(nameValue);

        //then
        assertThat(carNames).isNotNull();
        assertThat(carNames.getNames().size()).isEqualTo(expectedSize);
    }

    @DisplayName("잘못된 이름목록을 받은경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {",", "1,,2", ",1", "1,"})
    void newCarNamesWithWrongStringValue(String nameValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNames.newInstance(nameValue))
                .withMessage("[" + nameValue + "]잘못된 입력입니다.");
    }
}
