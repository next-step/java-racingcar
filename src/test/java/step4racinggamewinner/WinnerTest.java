package step4racinggamewinner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    Cars cars;
    Winners winners;

    @ParameterizedTest
    @MethodSource("winners")
    void 우승자_찾기(int redPositionNumber, int kakiPositionNumber, int bluePositionNumber, List<String> winnersList) {
        Car red = new Car("red", redPositionNumber);
        Car kaki = new Car("kaki", kakiPositionNumber);
        Car blue = new Car("blue", bluePositionNumber);
        cars = new Cars(red, kaki, blue);
        winners = new Winners(cars);
        assertThat(winners.findWinner()).isEqualTo(winnersList);
    }

    static Stream<Arguments> winners() {
        return Stream.of(
                Arguments.of(4, 2, 4, List.of("red", "blue")),
                Arguments.of(2, 4, 2, List.of("kaki")),
                Arguments.of(2, 2, 4, List.of("blue")),
                Arguments.of(4, 3, 2, List.of("red"))
        );
    }


}
