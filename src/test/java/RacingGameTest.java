
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Car;
import racing.RacingGame;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racing.RacingGame.SEPARATOR;


public class RacingGameTest {
    @DisplayName("무브의 파라미터가 4 이상이면 이동, 4미만이면 이동 안함.")
    @Test
    public void moveCarsTest() {
        //given
        String carString = "aaa,bbb,ccc";
        String[] carNameArray = carString.split(SEPARATOR);
        Car car = new Car(carNameArray[0]);
        Car car2 = new Car(carNameArray[1]);
        int car1BeforeDistance = car.getMoveCount();

        //when
        car.move(5);
        car2.move(3);

        //then
        assertAll(
                () -> assertThat(car.getMoveCount()).isEqualTo(car1BeforeDistance + 1),
                () -> assertThat(car2.getMoveCount()).isEqualTo(car1BeforeDistance)
        );
    }

    @Test
    public void findWinnerTest() throws Exception {
        //given
        RacingGame racingGame = new RacingGame();
        Method method;
        String carString = "aaa,bbb,ccc,ddd,eee,fff";
        String[] carNameArray = carString.split(SEPARATOR);
        method = racingGame.getClass().getDeclaredMethod("makeCars", String[].class);
        method.setAccessible(true);
        List<Car> carList = (List<Car>) method.invoke(racingGame, (Object) carNameArray);
        method = racingGame.getClass().getDeclaredMethod("moveCars", List.class);
        method.setAccessible(true);

        //when
        method.invoke(racingGame, carList);
        method = racingGame.getClass().getDeclaredMethod("findWinner", List.class);
        method.setAccessible(true);
        List<Car> winnerList = (List<Car>) method.invoke(racingGame, carList);

        //then
        assertThat(winnerList.size()).isNotEqualTo(0);
    }

    @Test
    public void repeatMoveCarsTest() {
        //given
        String carString = "aaa,bbb,ccc,ddd,eee,fff";
        String[] carNameArray = carString.split(SEPARATOR);

        //then
        assertAll(
                () -> assertDoesNotThrow(() -> new Car(carNameArray[0]).move(3)),
                () -> assertDoesNotThrow(() -> new Car(carNameArray[0]).move(4)),
                () -> assertDoesNotThrow(() -> new Car(carNameArray[0]).move(5))
        );
    }
}
