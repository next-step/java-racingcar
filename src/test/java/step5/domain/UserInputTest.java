package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {
    @Test
    @DisplayName("UserInput을 생성할 때 저장된 자동차 이름들을 확인한다.")
    void getCarNames() {
        // given
        final int tryNumber = 3;
        final String[] carNames = {"test1", "test2", "test3"};
        UserInput input = new UserInput(carNames, tryNumber);

        // when
        final String[] carNamesResult = input.getCarNames();

        // then
        assertThat(carNamesResult).isEqualTo(carNames);
    }

    @Test
    @DisplayName("UserInput을 생성할 때 저장된 시도 횟수를 확인한다.")
    void getTryNumber() {
        // given
        final int tryNumber = 6;
        final String[] carNames = {"test2", "test3", "test6"};
        UserInput input = new UserInput(carNames, tryNumber);

        // when
        final int tryNumberResult = input.getTryNumber();

        // then
        assertThat(tryNumberResult).isEqualTo(tryNumber);
    }
}
