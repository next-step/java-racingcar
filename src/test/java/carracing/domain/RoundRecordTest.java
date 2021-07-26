package carracing.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RoundRecordTest {

    @Test
    @DisplayName("carStatuses 리스트가 null 인 경우")
    public void carStatusesNull() {
        // given
        List<CarStatus> carStatuses = null;
        String message = RoundRecord.NON_NULL_CAR_STATUSES;

        // when
        ThrowingCallable throwingCallable = () -> new RoundRecord(carStatuses);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("carStatuses 리스트가 비어있는 경우")
    public void carStatusesEmpty() {
        // given
        List<CarStatus> carStatuses = Collections.EMPTY_LIST;
        String message = RoundRecord.NOT_EMPTY_CAR_STATUSES;

        // when
        ThrowingCallable throwingCallable = () -> new RoundRecord(carStatuses);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("정상적으로 carStatuses 반환하는지 테스트")
    public void getCarStatuses() {
        // given
        List<CarStatus> carStatuses = Arrays.asList(
                new CarStatus("iiaii", 1),
                new CarStatus("!!e!!", 2));
        int expectedSize = 2;

        // when
        RoundRecord roundRecord = new RoundRecord(carStatuses);

        // then
        assertThat(roundRecord.getCarStatuses().size()).isEqualTo(expectedSize);
    }

}