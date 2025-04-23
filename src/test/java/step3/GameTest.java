package step3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class GameTest {
    @DisplayName("주어진 횟수만큼 자동차들이 이동 전략을 수행한다")
    @Test
    void cars_move는_raceCount_횟수만큼_호출된다() {
        int carCount = 2;
        int raceCount = 3;

        Cars mockCars = Mockito.mock(Cars.class);
        when(mockCars.move()).thenReturn(generateDummyPositions(carCount));

        RaceCount race = new RaceCount(raceCount);
        Game game = new Game(mockCars, race);

        game.start(); //when

        verify(mockCars, times(raceCount)).move(); //then
    }

    private List<Position> generateDummyPositions(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Position())
                .collect(Collectors.toList());
    }
}