package carracing.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}