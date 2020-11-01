package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {
    @Test
    @DisplayName("Car객체 개수만큼 생성")
    void createCars() {
        int carNum = 4;

        GameManager gameManager = new GameManager();
        List<Car> cars = gameManager.createCars(carNum);

        assertThat(cars).hasSize(carNum);
    }
}
