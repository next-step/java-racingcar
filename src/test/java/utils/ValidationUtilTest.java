package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameDuplicateException;
import racingcar.exception.CarNameEmptyException;
import racingcar.exception.CarNameOverSizeException;
import racingcar.utils.ValidateUtil;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;



public class ValidationUtilTest {

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void validateNormalCase() {
        String[] carNames = {"maa", "ama", "mmam", "amm"};
        assertThatNoException()
                .isThrownBy(() ->
                        ValidateUtil.validateCarNames(carNames)
                );
    }

    @Test
    @DisplayName("자동차 이름 길이 검증 테스트")
    void validateCarNamesLengthTest() {
        String[] carNames = {"mmm", "mmmm", "mmmmm", "mmmmmm"};
        assertThatThrownBy(() -> {
            ValidateUtil.validateCarNames(carNames);
        }).isInstanceOf(CarNameOverSizeException.class);
    }

    @Test
    @DisplayName("자동차 이름 중복 검증 테스트")
    void validateDuplicateCarNames() {
        String[] carNames = {"mmm", "mmmm", "mmmm", "mmmmm"};
        assertThatThrownBy(() -> {
            ValidateUtil.validateCarNames(carNames);
        }).isInstanceOf(CarNameDuplicateException.class);
    }

    @Test
    @DisplayName("자동차 이름 누락 검증 테스트")
    void validateEmptyCarNames() {
        String[] carNames = {};
        assertThatThrownBy(() -> {
            ValidateUtil.validateCarNames(carNames);
        }).isInstanceOf(CarNameEmptyException.class);
    }
}
