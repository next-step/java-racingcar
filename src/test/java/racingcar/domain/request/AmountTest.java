package racingcar.domain.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {

    @DisplayName("클래스가 포함하는 값에 대한 테스트")
    @ParameterizedTest(name = "현재 반복 : {index} / 전체 반복 : {arguments}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void getAmountTest(int expected) {

        // given
        Amount amount = Amount.getInstance(expected);

        // when
        int actual = amount.getValue();

        // them
        assertThat(actual).isEqualTo(expected);

    }

    @DisplayName("적절하지 않은 값으로 클래스를 생성시 IllegalArgumentException 을 반환하는지에 대한 테스트")
    @ParameterizedTest(name = "현재 반복 : {index} / 전체 반복 : {arguments}")
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10})
    void getAmount_MINUSVALUE_IllegalArgumentException(int expected) {

        // when and then
        assertThatThrownBy(() -> {
            assertThat(Amount.getInstance(expected));
        }).isInstanceOf(IllegalArgumentException.class);

    }


}