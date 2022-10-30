package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LocationTest {

    public static Stream<Arguments> provideLocation() {
        return Stream.of(
                Arguments.of(new Location(2), -1),
                Arguments.of(new Location(1), 0),
                Arguments.of(new Location(0), 1)
        );
    }

    @Test
    @DisplayName("위치는 0보다 작을 수 없습니다.")
    void location_under_zero() {
        assertThatThrownBy(() -> new Location(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 0보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("다음 위치는 기존 값에 1을 더한다.")
    void next_location() {
        Location location = new Location(1);
        location.next();
        assertThat(location).isEqualTo(new Location(2));
    }

    @ParameterizedTest
    @DisplayName("비교값 보다 크면 1, 같으면 0, 작으면 -1을 반환 한다.")
    @MethodSource("provideLocation")
    void compare_small_location(Location location, int result) {
        assertThat(new Location(1).compareTo(location)).isEqualTo(result);
    }
}
