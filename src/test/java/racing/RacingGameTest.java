package racing;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class RacingGameTest {
    Random random = new Random();
    RacingGame racingGame;
    CarResult carResult;

    @Before
    public void setUp()  {
        String str = "pobi,crong,honux";
        int count = 5;
        racingGame = new RacingGame(str,count);
        carResult = new CarResult();
    }

    @Test
    public void 랜덤학습테스트() {
        int result = 0;
        for(int i = 0; i < 100; i++){
            result = random.nextInt(10);
            assertThat(result).isGreaterThanOrEqualTo(0);
            assertThat(result).isLessThan(10);
        }
    }
    @Test
    public void 준비_및_초기화확인() {
        List<Car> cars = Arrays.asList(new Car("pobi", 1) , new Car("crong",3), new Car("honux",2));

        for(int i =0; i < racingGame.getCarCount(); i++){
            assertThat(racingGame.getName(i)).isEqualTo(cars.get(i).getName());
        }
    }
    @Test
    public void 이동_및_이동거리확인() {
        List<Car> result = racingGame.getCars();
        for(int i =0; i < racingGame.getTime(); i++){
            racingGame.move();
        }

        for(int i =0; i < result.size(); i++){
            assertThat(result.get(i).getPosition()).isLessThanOrEqualTo(6);
        }
    }



    @Test
    public void 플레이어초기화() {
        assertThat(racingGame.getCarCount()).isEqualTo(3);
        assertThat(racingGame.getName(0)).isEqualTo("pobi");
    }


    @Test
    public void 끝이콤마로끝나면() {
        String str = "pobi,crong,honux,";
        int count = 5;
        racingGame = new RacingGame(str,count);
        assertThat(racingGame.getCarCount()).isEqualTo(3);
        assertThat(racingGame.getName(0)).isEqualTo("pobi");
        ResultView.watchRace(racingGame);
    }

    @Test(expected = NullPointerException.class)
    public void null값테스트() {
        racingGame = new RacingGame(null, 5);
    }

    @Test
    public void test(){
        ResultView.watchRace(racingGame);
    }

    @Test
    public void 최종결과테스트() {
        List<Car> cars = Arrays.asList(new Car("pobi", 1) , new Car("crong",3), new Car("honux",2));

        String result = CarResult.getRaceWinners(cars);
        assertThat(result).contains("crong");
    }

    @Test
    public void 최대거리테스트() {
        CarResult carResult = new CarResult();

        List<Car> cars = Arrays.asList(new Car("pobi", 1) , new Car("crong",4), new Car("honux",2));

        try {
            Method maxPositionMethod =carResult.getClass().getDeclaredMethod("getMaxPosition", List.class);
            maxPositionMethod.setAccessible(true);
            int max  = (int)maxPositionMethod.invoke(carResult,cars);
            assertThat(max).isEqualTo(4);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void 우승자구하기테스트_우승자길이구하기() {
        List<Car> cars = Arrays.asList(new Car("pobi", 1) , new Car("crong",3), new Car("honux",2));

        int max = carResult.getMaxPosition( cars);
        assertThat((carResult.getWinners(cars,max))).contains("crong");
        assertThat((carResult.getWinners(cars,5).length())).isEqualTo(0);
    }

    @Test
    public void 우승자구하기테스트_우승자출력하기() {
        List<Car> cars = Arrays.asList(new Car("pobi", 1) , new Car("crong",3), new Car("honux",4));
        String result = carResult.getRaceWinners(cars);
        assertThat(result).isEqualTo("honux가 최종 우승했습니다.");
    }


}