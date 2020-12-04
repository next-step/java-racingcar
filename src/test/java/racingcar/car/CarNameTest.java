package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarNameTest {
    @DisplayName("이름이 5자 이하인 경우 carName 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void newCarNameWithNormalName(String name) {
        //when
        CarName carName = CarName.newInstance(name);

        //then
        assertEquals(name, carName.getName());
    }

    @DisplayName("이름이 잘못된 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void newCarNameWithWrongName(String name) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarName.newInstance(name))
                .withMessage("[" + name + "]잘못된 자동차 이름입니다. 1~5자의 이름을 입력하세요.");
    }
}

