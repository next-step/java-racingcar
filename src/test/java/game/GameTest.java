package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    @DisplayName("자동차 여러 개 주행 상태 표시하기")
    public void positionsOfMultipleCars() {
        Car mySpringCar = new Car(1);
        Car mySummerCar = new Car(2);
        Car myAutumnCar = new Car(3);
        Car myWinterCar = new Car(4);

        Game game = new Game(List.of(mySpringCar, mySummerCar, myAutumnCar, myWinterCar));

        assertThat(game.getCarsTrajectories())
                .isEqualTo("-\n--\n---\n----");
    }

    @Test
    @DisplayName("자동차 없어도 상태 표시하기")
    public void positionOfNoCar() {
        Game game = new Game();

        assertThat(game.getCarsTrajectories())
                .isEqualTo("");
    }

    @Test
    @DisplayName("한 사이클 진행")
    public void oneCycle() {
        Car mySpringCar = Mockito.mock(Car.class);
        Car mySummerCar = Mockito.mock(Car.class);

        Game game = new Game(List.of(mySpringCar, mySummerCar));
        game.doACycle();

        Mockito.verify(mySpringCar).go();
        Mockito.verify(mySummerCar).go();
    }
}
