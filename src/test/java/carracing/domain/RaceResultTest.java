package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RaceResultTest {

    @DisplayName("레이스 결과에서 우승자를 추출할 수 있다.")
    @Test
    public void extractWinnersTest() {
        Map<Position, List<Car>> mockCarPositions = createMockCarPositions();
        RaceResult raceResult = RaceResult.of(mockCarPositions);
        Position winnerPosition = mockCarPositions.keySet().stream().max(Position::compareTo).get();
        assertThat(raceResult.getWinners())
                .isEqualTo(mockCarPositions.get(winnerPosition));
    }

    private Map<Position, List<Car>> createMockCarPositions() {
        List<Position> positions = Arrays.asList(Position.of(3), Position.of(1), Position.of(2));
        return positions.stream()
                .collect(Collectors.toMap(Function.identity(), position -> createCars(position)));
    }

    private List<Car> createCars(Position position) {
        return Stream.generate(() -> Car.of(position, CarName.of("name")))
                .limit(3)
                .collect(Collectors.toList());
    }

}