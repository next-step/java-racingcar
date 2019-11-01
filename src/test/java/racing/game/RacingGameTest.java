package racing.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.game.Car;
import racing.game.RacingGame;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @DisplayName("car 개수가 조건대로 생성이 되었는지 확인")
    @Test
    void doGameCarSizeTest() {
        RacingGame racingGame = new RacingGame("카1,카2", 5);
        List<Car> carList = racingGame.doGame();

        assertThat(carList.size()).isEqualTo(2);
    }

    @DisplayName("doGame 후 position개수와 위치가 맞는지 확인")
    @Test
    void doGamePositionTest() {
        RacingGame racingGame = new RacingGame("카1,카2", 2);
        List<Car> carList = racingGame.doGame();

        assertThat(carList.get(0).getPosition(0)).isBetween(0, 1);
        assertThat(carList.get(0).getPosition(1)).isBetween(0, 2);

        assertThatThrownBy(() -> {
            carList.get(0).getPosition(2);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

   @DisplayName("getWinner 단일 우승 테스트")
    @Test
    void getWinnerTest1() {
        List<Car> cars = new ArrayList<>();

        Car a = new Car("aaa");
        a.move(() ->{ return true;});
        a.move(() ->{ return true;});
        cars.add(a);

        Car b = new Car("bbb");
        b.move(() ->{ return false;});
        b.move(() ->{ return false;});
        cars.add(b);

        RacingGame racingGame = new RacingGame(cars, 2);
        assertThat(racingGame.getWinner()).isEqualTo(Arrays.asList("aaa"));
    }

    @DisplayName("getWinner 복수 우승 테스트")
    @Test
    void getWinnerTest2() {
        List<Car> cars = new ArrayList<>();

        Car a = new Car("aaa");
        a.move(() ->{ return true;});
        a.move(() ->{ return true;});
        cars.add(a);

        Car b = new Car("bbb");
        b.move(() ->{ return true;});
        b.move(() ->{ return true;});
        cars.add(b);

        RacingGame racingGame = new RacingGame(cars, 2);
        assertThat(racingGame.getWinner()).isEqualTo(Arrays.asList("aaa", "bbb"));
    }

}