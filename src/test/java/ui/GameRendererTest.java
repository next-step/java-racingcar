package ui;

import game.Car;
import game.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRendererTest {
    @Test
    @DisplayName("자동차 여러 개 주행 상태 표시하기")
    public void positionsOfMultipleCars() {
        Car mySpringCar = new Car(1);
        Car mySummerCar = new Car(2);
        Car myAutumnCar = new Car(3);
        Car myWinterCar = new Car(4);

        Game game = new Game(List.of(mySpringCar, mySummerCar, myAutumnCar, myWinterCar));

        assertThat(GameRenderer.getGameRendering(game))
                .isEqualTo("-\n--\n---\n----");
    }

    @Test
    @DisplayName("자동차 없어도 상태 표시하기")
    public void positionOfNoCar() {
        Game game = new Game();

        assertThat(GameRenderer.getGameRendering(game))
                .isEqualTo("");
    }
}
