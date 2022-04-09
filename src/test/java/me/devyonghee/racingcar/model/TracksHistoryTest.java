package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("경주로들 기록")
class TracksHistoryTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> TracksHistory.from(Collections.emptyList()));
    }

    @Test
    @DisplayName("컬렉션은 필수")
    void instance_nullCollection_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> TracksHistory.from(null));
    }
}
