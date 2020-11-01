package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    @Test
    @DisplayName("Car객체 개수만큼 생성")
    void createCars() {
        int carNum = 4;

        Discriminator discriminator = new Discriminator(new Random());
        GameManager gameManager = new GameManager(discriminator);
        List<Car> cars = gameManager.createCars(carNum);

        assertThat(cars).hasSize(carNum);
    }

    @Test
    @DisplayName("car를 모두 move하게 하여 테스트")
    void move_fullMovement() {
        Discriminator discriminator = new Discriminator(DiscriminatorTest.getMockRandom(4));
        GameManager gameManager = new GameManager(discriminator);
        List<Car> cars = gameManager.createCars(3);

        gameManager.move(cars);

        cars.stream().forEach(car ->
                assertThat(car).hasToString("-")
        );
    }

    @Test
    @DisplayName("car를 모두 move하지 못하게 하여 테스트")
    void move_noMovement() {
        Discriminator discriminator = new Discriminator(DiscriminatorTest.getMockRandom(3));
        GameManager gameManager = new GameManager(discriminator);
        List<Car> cars = gameManager.createCars(3);

        gameManager.move(cars);

        cars.stream().forEach(car ->
                assertThat(car).hasToString("")
        );
    }
}
