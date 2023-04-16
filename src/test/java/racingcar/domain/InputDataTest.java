package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static racingcar.domain.fixture.CarConstantsFixture.CAR_NAMES;
import static racingcar.domain.fixture.CarConstantsFixture.CAR_NAME_ERROR_MESSAGE;
import static racingcar.domain.fixture.CarConstantsFixture.ROUND_COUNT;
import static racingcar.domain.fixture.CarConstantsFixture.TRY_COUNT_ERROR_MESSAGE;
import static racingcar.domain.fixture.CarConstantsFixture.WEIRD_CAR_NAME_1;
import static racingcar.domain.fixture.CarConstantsFixture.WEIRD_CAR_NAME_2;

class InputDataTest {

    @Test
    @DisplayName("입력받은 자동차 이름과 시도 횟수를 저장한다.")
    void inputData_test() {
        // Given & When
        InputData inputData = new InputData(CAR_NAMES, ROUND_COUNT);

        // Then
        assertAll(
                () -> assertEquals(CAR_NAMES, inputData.getRawString()),
                () -> assertEquals(ROUND_COUNT, inputData.getRoundCount())
        );
    }

    @Test
    @DisplayName("사용자 입력 예외 테스트")
    void testNameException() {
        // Then & When
        assertAll(
                () -> assertThatThrownBy(() -> new InputData(WEIRD_CAR_NAME_1, ROUND_COUNT))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(CAR_NAME_ERROR_MESSAGE),

                () -> assertThatThrownBy(() -> new InputData(WEIRD_CAR_NAME_2, ROUND_COUNT))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(CAR_NAME_ERROR_MESSAGE),

                () -> assertThatThrownBy(() -> new InputData(CAR_NAMES, 0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(TRY_COUNT_ERROR_MESSAGE)
        );
    }

}