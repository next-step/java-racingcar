package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("RacingGame Constructor Test")
    public void constructorTest() {
        List<Car> carList = Arrays.asList(
                new Car(1,"name1",1)
                , new Car(1,"name1",2)
        );
        RacingGame racingGame = new RacingGame(carList, 5);
        assertThat(racingGame.getCarList().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Remain TryCount Test")
    public void remainTryCountTest() {
        List<Car> carList = Arrays.asList(
                new Car(1,"name1",1)
                , new Car(1,"name1",2)
                , new Car(1,"name1",3)
        );
        RacingGame racingGame = new RacingGame(carList, 2);
        assertThat(racingGame.remainTryCount()).isTrue();
        racingGame = new RacingGame(carList, 0);
        assertThat(racingGame.remainTryCount()).isFalse();
    }

    @Test
    @DisplayName("Reduce TryCount Test")
    public void reduceTryCountTest() {
        List<Car> carList = Arrays.asList(
                new Car(1,"name1",1)
                , new Car(1,"name2",2)
                , new Car(1,"name3",3)
        );
        RacingGame racingGame = new RacingGame(carList, 2);
        racingGame.reduceTryCount();
        assertThat(racingGame)
                .usingRecursiveComparison()
                .comparingOnlyFields("carList", "tryCount")
                .isEqualTo(new RacingGame(carList, 1));
    }

    @Test
    public void getWinnersTest() throws NoSuchMethodException {
        List<Car> carList = Arrays.asList(
                new Car(1,"name1",1)
                , new Car(1,"name2",2)
                , new Car(1,"name3",3)
        );
        RacingGame racingGame = new RacingGame(carList,0);
        Method method = racingGame.getClass().getDeclaredMethod("getWinnerList");
        method.setAccessible(true);

        List<String> expectedWinnerList = Arrays.asList("name3");

        try {
            racingGame.getWinners();
            assertThat(method.invoke(racingGame)).isEqualTo(expectedWinnerList);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getMaxPostionTest() throws NoSuchMethodException {
        List<Car> carList = Arrays.asList(
                new Car(1,"name1",1)
                , new Car(1,"name1",2)
                , new Car(1,"name1",3)
        );

        RacingGame racingGame = new RacingGame(carList,3);
        Method method = racingGame.getClass().getDeclaredMethod("getMaxPosition");
        method.setAccessible(true);

        try {
            assertThat(method.invoke(racingGame)).isEqualTo(3);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}