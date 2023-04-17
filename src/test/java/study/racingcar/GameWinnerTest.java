package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameWinnerTest {

    @DisplayName("자동차 경주 중 최고 거리의 위치를 반환한다.")
    @Test
    public void gameWinner_getMaxPosition() {

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car(3, "pobbi", new CarMoveStrategy());
        Car car2 = new Car(5, "crong", new CarMoveStrategy());
        Car car3 = new Car(4, "honux", new CarMoveStrategy());

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameWinner gameWinner = new GameWinner(carList);

        assertThat(gameWinner.getMaxPosition(carList)).isEqualTo(5);

    }

    @DisplayName("동일한 최고 거리가 1명이면 우승자는 1명이다.")
    @Test
    public void gameWinner_findGameWinner_우승자1명() {

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car(3, "pobbi", new CarMoveStrategy());
        Car car2 = new Car(5, "crong", new CarMoveStrategy());
        Car car3 = new Car(8, "honux", new CarMoveStrategy());

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameWinner gameWinner = new GameWinner(carList);

        assertThat(gameWinner.findGameWinner()).hasSize(1);

    }

    @DisplayName("동일한 최고 거리가 2명이면 우승자는 2명이다.")
    @Test
    public void gameWinner_findGameWinner_우승자2명() {

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car(3, "pobbi", new CarMoveStrategy());
        Car car2 = new Car(5, "crong", new CarMoveStrategy());
        Car car3 = new Car(5, "honux", new CarMoveStrategy());

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        GameWinner gameWinner = new GameWinner(carList);

        assertThat(gameWinner.findGameWinner()).hasSize(2);

    }
}
