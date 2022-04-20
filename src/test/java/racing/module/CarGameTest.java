package racing.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class CarGameTest {
    private final MoveStrategy alwaysTrueStrategy = () -> true;
    private final MoveStrategy alwaysFalseStrategy = () -> false;

    @Test
    @DisplayName("대수가 맞게 생성되었는지 확인")
    void carGame() {
        CarGame carGame = new CarGame("a,b,c");
        assertThat(carGame.getCarList()).hasSize(3);
    }

    @Test
    @DisplayName("생성된 자동차들이 모두 움직였는지 확인")
    void alwayMovingplay() {
        CarGame carGame = new CarGame("a,b,c");
        carGame.play(alwaysTrueStrategy);
        for (Car car : carGame.getCarList()) {
            assertThat(car.getPosition()).isEqualTo(1);

        }
    }

    @Test
    @DisplayName("생성된 자동차들이 모두 안움직였는지 확인")
    void alwayStayplay() {
        CarGame carGame = new CarGame("a,b,c");
        carGame.play(alwaysFalseStrategy);
        for (Car car : carGame.getCarList()) {
            assertThat(car.getPosition()).isEqualTo(0);

        }
    }

    @Test
    @DisplayName("제일 많이 움직인 위치가 맞는지 확인")
    void getMaxPosition() {
        CarGame carGame = new CarGame("a,b,c");
        List<Car> carList = carGame.getCarList();
        for (Car car : carList) {
            if (Objects.equals(car.getCarName(), "a")) {
                car.attempt(alwaysTrueStrategy);
                car.attempt(alwaysTrueStrategy);
            }

            if (Objects.equals(car.getCarName(), "b")) {
                car.attempt(alwaysTrueStrategy);
            }
        }
        assertThat(carGame.getMaxPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자가 맞는지 확인")
    void getWinner() {
        CarGame carGame = new CarGame("a,b,c");
        List<Car> carList = carGame.getCarList();
        for (Car car : carList) {
            if (Objects.equals(car.getCarName(), "a")) {
                car.attempt(alwaysTrueStrategy);
            }
        }
        assertThat(carGame.getWinner().size()).isEqualTo(1);
        assertThat(carGame.getWinner().get(0).getCarName()).isEqualTo("a");
    }
}