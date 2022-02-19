import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class WinnersTest {

    @Test
    @DisplayName("position 이 가장 큰 차들이 우승자가 된다 1")
    void decideWinners1() {
        //given
        Random randomNumberMock = Mockito.mock(Random.class);
        when(randomNumberMock.nextInt(anyInt())).thenReturn(4);

        String[] carNames = {"a", "b", "c"};
        Cars cars = Cars.of(carNames);

        for (int i = 0; i < 4; i++) {
            cars.getCars().get(0).moveRandom(randomNumberMock);
        }
        for (int i = 0; i < 3; i++) {
            cars.getCars().get(1).moveRandom(randomNumberMock);
        }
        for (int i = 0; i < 2; i++) {
            cars.getCars().get(2).moveRandom(randomNumberMock);
        }

        List<String> winnerCarNames = new ArrayList<>();
        winnerCarNames.add("a");

        //when
        Winners winners = Winners.decideWinners(cars);

        //then
        assertThat(winners.getCars().size()).isEqualTo(1);
        winners.getCars().forEach(car -> assertThat(winnerCarNames).contains(car.getCarName()));
    }

    @Test
    @DisplayName("position 이 가장 큰 차들이 우승자가 된다 2")
    void decideWinners2() {
        //given
        Random randomNumberMock = Mockito.mock(Random.class);
        when(randomNumberMock.nextInt(anyInt())).thenReturn(4);

        String[] carNames = {"a", "b", "c"};
        Cars cars = Cars.of(carNames);

        for (int i = 0; i < 4; i++) {
            cars.getCars().get(0).moveRandom(randomNumberMock);
        }
        for (int i = 0; i < 2; i++) {
            cars.getCars().get(1).moveRandom(randomNumberMock);
        }
        for (int i = 0; i < 4; i++) {
            cars.getCars().get(2).moveRandom(randomNumberMock);
        }

        List<String> winnerCarNames = new ArrayList<>();
        winnerCarNames.add("a");
        winnerCarNames.add("c");

        //when
        Winners winners = Winners.decideWinners(cars);

        //then
        assertThat(winners.getCars().size()).isEqualTo(2);
        winners.getCars().forEach(car -> assertThat(winnerCarNames).contains(car.getCarName()));
    }
}