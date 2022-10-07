package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름 생성에 성공")
    void createCarNameSuccess() {
        CarName carName = new CarName("test");
        assertThat(carName.getName())
                .isEqualToIgnoringCase("test");
    }

    @Test
    @DisplayName("입력된 자동차 이름이 5글자 초과로 실패")
    void createCarNameFailByMoreThanFiveCharacters() {
        assertThatThrownBy(
                () -> new CarName("anakin"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 자동차 이름이 빈 문자열로 실패")
    void createCarNameFailByEmptyInput() {
        assertThatThrownBy(
                () -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 자동차 이름이 null 값으로 실패")
    void createCarNameFailByNullInput() {
        assertThatThrownBy(
                () -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
