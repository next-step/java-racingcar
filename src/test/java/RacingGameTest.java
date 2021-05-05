import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Car;
import racing.RacingGame;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racing.RacingGame.SEPARATOR;


public class RacingGameTest {

    @Test
    @DisplayName("자동차 이름이 전부 5자 이내인 자동차 생성")
    public void makeCarTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        RacingGame racingGame = new RacingGame();
        Method method;
        String carString = "aaa,bbb,ccc";
        String[] carNameArray = carString.split(SEPARATOR);
        method = racingGame.getClass().getDeclaredMethod("makeCarList", String[].class);
        method.setAccessible(true);

        //when
        List<Car> carList = (List<Car>) method.invoke(racingGame, (Object) carNameArray);

        //then
        assertAll(
                () -> assertThat(carList.get(0).getName()).isEqualTo("aaa"),
                () -> assertThat(carList.get(1).getName()).isEqualTo("bbb"),
                () -> assertThat(carList.get(2).getName()).isEqualTo("ccc")
        );
    }

    @Test
    @DisplayName("자동차 이름중 일부가 5자 초과")
    public void invalidMakeCarTest() {
        //given
        String carString = "aaa,bbb,cccccc";
        String[] carNameArray = carString.split(SEPARATOR);

        //when

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(carNameArray[2]);
                });
    }

    @Test
    public void moveCarsTest() {
        //given
        String carString = "aaa,bbb,ccc";
        String[] carNameArray = carString.split(SEPARATOR);
        Car car = new Car(carNameArray[0]);
        Car car2 = new Car(carNameArray[1]);
        int car1BeforeDistance = car.getMoveCount();
        int car2BeforeDistance = car2.getMoveCount();

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
        method = racingGame.getClass().getDeclaredMethod("makeCarList", String[].class);
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
                () -> Assertions.assertDoesNotThrow(() -> new Car(carNameArray[0]).move(3)),
                () -> Assertions.assertDoesNotThrow(() -> new Car(carNameArray[0]).move(4)),
                () -> Assertions.assertDoesNotThrow(() -> new Car(carNameArray[0]).move(5))
        );
    }
}
