package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class ValidTest {

    @DisplayName("이름이 null이거나 공백일때 에러발생")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmptyWithNull(String input) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Valid.isEmpty(input));

    }

    @DisplayName("반복횟수가 -거나, 0일때")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void timeGreaterThenZeroWithError(int input) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Valid.timeGreaterThenZero(input));

    }

    @DisplayName("반복횟수가 0이상일때")
    @Test
    void timeGreaterThenZeroWithSuccess() {
        Valid.timeGreaterThenZero(2);
    }

    @DisplayName("위치값이  -일때")
    @Test
    void positionMinusCheckWithError() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Valid.positionMinusCheck(-1));
    }

    @DisplayName("위치값이  -이상 일때")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void positionMinusCheckWithSuccess(int input) {
        Valid.positionMinusCheck(input);
    }

    @DisplayName("carNames가 null일때")
    @Test
    void sizeCompareWithCarNamesIsNull() {
        int[] positions = {1, 2, 3};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Valid.sizeCompare(null, positions);
        });
    }

    @DisplayName("postions가 null일때")
    @Test
    void sizeCompareWithPositionIsNull() {
        String[] names = {"A", "B", "C"};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Valid.sizeCompare(names, null);
        });
    }

    @DisplayName("postions와 names사이즈가 일치하지 않을때")
    @Test
    void sizeCompareNamesAndPostionsSizeNotEqual() {
        String[] names = {"A", "B", "C"};
        int[] positions = {1, 2};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Valid.sizeCompare(names, positions);
        });
    }

    @DisplayName("postions와 names사이즈가 일치할때")
    @Test
    void sizeCompareNamesAndPostionsSizeEqual() {

        String[] names = {"A", "B", "C"};
        int[] positions = {1, 2, 3};

        Valid.sizeCompare(names, positions);

    }

}