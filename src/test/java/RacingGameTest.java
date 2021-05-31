import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.RacingGame;
import racing.utils.ConvertString;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RacingGameTest {

    @Test
    @DisplayName("자동차 이름이 전부 5자 이내인 자동차 생성")
    void makeCarTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        RacingGame racingGame = new RacingGame();
        String carString = "aaa,bbb,ccc";
        String[] carNames = ConvertString.splitString(carString);
        Method method = racingGame.getClass().getDeclaredMethod("makeCars", String[].class);
        method.setAccessible(true);

        //when
        List<Car> cars = (List<Car>) method.invoke(racingGame, (Object) carNames);

        //then
        assertEquals("aaa", cars.get(0).getName());
        assertEquals("bbb", cars.get(1).getName());
        assertEquals("ccc", cars.get(2).getName());
    }

    @Test
    @DisplayName("자동차 이름중 일부가 5자 초과")
    void makeCarTest2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        RacingGame racingGame = new RacingGame();
        Method method;
        String carString = "aaa,bbb,cccccc";
        String[] carNames = ConvertString.splitString(carString);
        method = racingGame.getClass().getDeclaredMethod("makeCars", String[].class);
        method.setAccessible(true);

        //when

        //then

        org.assertj.core.api.Assertions.assertThatExceptionOfType(InvocationTargetException.class)
                .isThrownBy(() -> {
                    method.invoke(racingGame, (Object) carNames);
                });
    }

    @Test
    void moveCountChangeTest() throws Exception {
        //given
        RacingGame racingGame = new RacingGame();
        List<Car> cars = Arrays.asList(new Car("aaa"), new Car("bbb"), new Car("ccc"));

        //when
        Method method = racingGame.getClass().getDeclaredMethod("moveCountChange", List.class);
        method.setAccessible(true);
        method.invoke(racingGame, cars);

        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getName() + ": " + cars.get(i).getMoveCount());
        }

        // moveCount가 변하는지 확인하는 테스트인데 모든 자동차가 움직이지 않는 경우도 있어서
        // 테스트를 만드는게 힘들거 같네요.... 이 테스트 말고 다른 테스트 케이스를 작성하는게 맞지 않을까 싶네요...ㅎㅎ
    }

    @Test
    void findWinnerTest() throws Exception {
        //given
        RacingGame racingGame = new RacingGame();
        String carString = "aaa,bbb,ccc,ddd,eee,fff";
        String[] carNames = ConvertString.splitString(carString);
        Method method = racingGame.getClass().getDeclaredMethod("makeCars", String[].class);
        method.setAccessible(true);
        List<Car> cars = (List<Car>) method.invoke(racingGame, (Object) carNames);
        method = racingGame.getClass().getDeclaredMethod("moveCountChange", List.class);
        method.setAccessible(true);

        //when
        method.invoke(racingGame, cars);
        method = racingGame.getClass().getDeclaredMethod("findWinner", List.class);
        method.setAccessible(true);
        List<Car> winnerList = (List<Car>) method.invoke(racingGame, cars);

        //then
        org.assertj.core.api.Assertions.assertThat(winnerList.size()).isNotEqualTo(0);
    }

    @Test
    void repeatCountTest() throws Exception {
        //given
        RacingGame racingGame = new RacingGame();
        String carString = "aaa,bbb,ccc,ddd,eee,fff";
        String[] carNames = ConvertString.splitString(carString);
        int repeatCount = 10;
        Method method = racingGame.getClass().getDeclaredMethod("makeCars", String[].class);
        method.setAccessible(true);
        List<Car> cars = (List<Car>) method.invoke(racingGame, (Object) carNames);
        System.out.println(cars);
        method = racingGame.getClass().getDeclaredMethod("repeatMoveCount", List.class, int.class);
        method.setAccessible(true);

        //when
        method.invoke(racingGame, cars, repeatCount);

        System.out.println(cars);
        org.assertj.core.api.Assertions.assertThat(cars.get(0).getMoveCount() >= 2).isTrue();
    }
}
