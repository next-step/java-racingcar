package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.LocationOutOfRangeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("위치(Location) 테스트")
public class LocationTest {

    @DisplayName("0과 양수를 허용한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    void allowPositiveAndZero(int value) {
        // when
        Location location = Location.valueOf(value);

        // then
        assertThat(location).isNotNull();

    }

    @DisplayName("음수 값은 허용하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    void notAllowNegative(int value) {
        // when / then
        assertThrows(LocationOutOfRangeException.class, () -> {
            Location ignore = Location.valueOf(value);
        }, String.format("음수 값(%d)는 허용하지 않습니다.", value));
    }

    @DisplayName("위치를 증가시킬 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    void forward(int value) {
        // given
        Location location = Location.valueOf(value);

        // when
        Location forward = location.forward();

        // then
        assertThat(forward).isEqualTo(Location.valueOf(value + 1));
    }

    @DisplayName("캐싱을 통해 같은 객체를 보장한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    void cache(int value) {
        // when
        Location location = Location.valueOf(value);
        Location other = Location.valueOf(value);

        // then
        assertThat(location).isSameAs(other);
    }
}
