package racingcar.domain;

import exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarErrorCode;
import racingcar.exception.RacingCarErrorCode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름 생성 테스트")
    void create_carName() {
        final String name = "test1";
        CarName carName = CarName.from(name);
        assertThat(carName.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("이름값이 정해진 길이보다 길면 생성에 실패한다")
    void create_carName_fail() {
        assertThatThrownBy(() -> CarName.from("test12345"))
                .isInstanceOf(CustomException.class)
                .hasMessage(CarErrorCode.CAR_NAME_LENGTH_BAD_REQUEST.getMessage());
    }
}