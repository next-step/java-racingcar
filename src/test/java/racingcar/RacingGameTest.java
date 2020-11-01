package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 클래스의 테스트")
class RacingGameTest {

    @ParameterizedTest
    @DisplayName("tryNum 보다 많이 play 하면 gameOver 되어야 한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void play(int loop) {
        String carCsv = "1,2,3";
        int tryNum = 5;
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        CarGroup carGroup = new CarGroup(carCsv, strategy);
        RacingGame game = new RacingGame(carGroup, tryNum);

        for (int i = 0; i < loop; i++) {
            game.play();
        }

        boolean expectedGameOver = loop < tryNum;
        assertThat(game.checkNotGameOver())
                .isEqualTo(expectedGameOver);
    }

    @Test
    @DisplayName("가장 getPosition 값이 큰 car 들이 Winner 가 된다.")
    void getWinners() {
        int carNum = 5;
        int maxPosition = Integer.MAX_VALUE;
        Car[] carArr = new Car[carNum];
        Function<Integer, Boolean> checkWinner = (Integer idx) -> (idx % 2 == 0);

        for (int i = 0; i < carNum; i++) {
            Car car = Mockito.mock(Car.class);
            boolean isWinner = checkWinner.apply(i);
            int position = isWinner ? maxPosition : i;
            Mockito.when(
                    car.getPosition()
            ).thenReturn(position);
            carArr[i] = car;
        }

        CarGroup carGroup = Mockito.mock(CarGroup.class);
        Mockito.when(
                carGroup.getCarStream()
        ).thenReturn(
                Arrays.stream(carArr)
        );

        int tryNum = 100;
        RacingGame game = new RacingGame(carGroup, tryNum);
        List<Car> winners = game.getWinners();

        List<Car> expectedWinners = new LinkedList<Car>();
        for (int i = 0; i < carNum; i++) {
            boolean isWinner = checkWinner.apply(i);
            if (!isWinner) {
                continue;
            }
            expectedWinners.add(carArr[i]);
        }

        assertThat(winners)
                .isEqualTo(expectedWinners);
    }
}
