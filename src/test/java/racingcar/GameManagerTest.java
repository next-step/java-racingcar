package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    GameManager gameManager;

    @BeforeEach
    void setUp() {
        this.gameManager = new GameManager();
    }

    @Test
    @DisplayName("게임 한 턴 플레이 테스트")
    void play_everyCarOneMovement() {
        int carNum = 3;
        int movementExpected = 1;
        List<Car> cars = gameManager.readyCars(carNum, () -> movementExpected);
        List<Integer> initialPositions = cars.stream().map(Car::getPosition).collect(Collectors.toList());

        gameManager.play();
        List<Integer> movements = IntStream.range(0, cars.size())
                .mapToObj(i -> cars.get(i).getPosition() - initialPositions.get(i))
                .collect(Collectors.toList());

        movements.stream().forEach(movement ->
                assertThat(movement).isEqualTo(movementExpected)
        );
    }

    @Test
    @DisplayName("Car 준비 시키기")
    void readyCars() {
        int carNum = 3;
        List<Car> cars = gameManager.readyCars(3, new MoveStrategyImpl());

        assertThat(cars).hasSize(carNum);
    }
}
