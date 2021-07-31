package carracing.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNamesTest {

    @Test
    @DisplayName("carNames 리스트가 null 인 경우")
    public void carNamesNull() {
        // given
        List<String> carNames = null;
        String message = CarNames.NON_NULL_CAR_NAMES;

        // when
        ThrowingCallable throwingCallable = () -> new CarNames(carNames);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("carNames 리스트가 비어있는 경우")
    public void carNamesEmpty() {
        // given
        List<String> carNames = Collections.EMPTY_LIST;
        String message = CarNames.NOT_EMPTY_CAR_NAMES;

        // when
        ThrowingCallable throwingCallable = () -> new CarNames(carNames);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("carNamesStream 가져오기")
    public void getCarNamesStream() {
        // given
        List<String> carNameStrings = Arrays.asList("iiaii", "!!e!!");
        CarNames carNames = new CarNames(carNameStrings);
        int expectedSize = 2;

        // when
        Stream<CarName> carNamesStream = carNames.getCarNamesStream();

        // then
        assertThat(carNamesStream.count()).isEqualTo(expectedSize);
    }

}