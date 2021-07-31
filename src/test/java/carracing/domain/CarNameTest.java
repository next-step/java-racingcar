package carracing.domain;

import carracing.controller.RaceController;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("carName 이 null 인 경우")
    public void nullCarName() {
        // given
        String carName = null;
        String message = CarName.NON_NULL;

        // when
        ThrowingCallable throwingCallable = () -> new CarName(carName);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("carName 이 공백이거나 비어있는 경우")
    public void emptyCarName() {
        // given
        String carName = " ";
        String message = CarName.NOT_EMPTY;

        // when
        ThrowingCallable throwingCallable = () -> new CarName(carName);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "getCarName 테스트 | {arguments}")
    @CsvSource(value = {"iiaii:iiaii", "!!e!!:!!e!!"}, delimiter = ':')
    public void getCarName(String name, String expected) {
        // given
        CarName carName = new CarName(name);

        // when
        String result = carName.getName();

        // then
        assertThat(result).isEqualTo(expected);
    }
}