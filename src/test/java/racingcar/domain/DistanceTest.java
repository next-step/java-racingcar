package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class DistanceTest {
    @DisplayName("거리를 증가시키면 거리는 1씩 증가한다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 3 })
    void increment(int distance) {
        assertThat(distance(distance).increment()).isEqualTo(distance( distance + 1));
    }

    @DisplayName("이름이 달라도 거리가 같으면 true 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("equalsSet")
    void equals(Distance distance, Distance other, boolean expected) {
        assertThat(distance.equals(other)).isEqualTo(expected);
    }

    @DisplayName("distance 의 거리가 other 의 거리보다 크다면 true 를 리턴하고 작거나 같다면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("greaterThanSet")
    void greaterThan(Distance distance, Distance other, boolean expected) {
        assertThat(distance.greaterThan(other)).isEqualTo(expected);
    }

    private static Distance distance(int distance) {
        return new Distance(distance);
    }

    private static Stream<Arguments> equalsSet() {
        return Stream.of(
                Arguments.arguments(new Distance(1), new Distance(1), true),
                Arguments.arguments(new Distance(1), new Distance(2), false)

        );
    }
    
    private static Stream<Arguments> greaterThanSet() {
        return Stream.of(
                Arguments.arguments(new Distance(5), new Distance(1), true),
                Arguments.arguments(new Distance(4), new Distance(4), false),
                Arguments.arguments(new Distance(3), new Distance(5), false)

        );
    }
}
