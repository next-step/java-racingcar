package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DistancesTest {
    private Distances distances;

    @BeforeEach
    void setUp() {
        distances = new Distances();
    }

    @DisplayName("이동거리 목록이 같으면 true 를 리턴하고 아니라면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("equalsSet")
    void equals(List<Distance> distances, List<Distance> other, boolean expected) {
        assertThat(new Distances(distances).equals(new Distances(other))).isEqualTo(expected);
    }

    @DisplayName("가장 긴 이동거리를 리턴한다.")
    @ParameterizedTest
    @MethodSource("longestSet")
    void longest(List<Distance> distances, List<Distance> expected) {
        assertThat(new Distances(distances).longest()).isEqualTo(new Distances(expected));
    }

    @DisplayName("이동한 자동차의 이름을 리턴한다.")
    @ParameterizedTest
    @MethodSource("namesSet")
    void names(List<Distance> distances, List<String> names) {
        assertThat(new Distances(distances).names()).hasSameElementsAs(names);
    }

    private static Stream<Arguments> namesSet() {
        return Stream.of(
                Arguments.arguments(List.of(distance("pobby")), List.of("pobby")),
                Arguments.arguments(List.of(distance("pobby"), distance("luna")), List.of("pobby", "luna"))
        );
    }

    private static Stream<Arguments> longestSet() {
        return Stream.of(
                Arguments.arguments(List.of(distance("pobby", 1), distance("rein", 3)),
                                    List.of(distance("rein", 3))),
                Arguments.arguments(List.of(distance("pobby", 1), distance("java", 5), distance("rein", 3)),
                                    List.of(distance("java", 5))),
                Arguments.arguments(List.of(distance("pobby", 1), 
                                            distance("java", 5), 
                                            distance("rein", 5)
                                    ),
                                    List.of(distance("java", 5), distance("rein", 5)))
        );
    }

    private static Stream<Arguments> equalsSet() {
        return Stream.of(
                Arguments.arguments(List.of(distance("pobby", 1), distance("rein", 1)),
                                    List.of(distance("rein", 1), distance("rein", 1)),
                                    true),
                Arguments.arguments(List.of(distance("luna", 1), distance("pobby", 2)),
                                    List.of(distance("luna", 1), distance("pobby", 1)),
                                    false)
        );
    }

    private static Distance distance(String name) {
        return new Distance(name);
    }
    
    private static Distance distance(String name, int distance) {
        return new Distance(name, distance);
    }
}
