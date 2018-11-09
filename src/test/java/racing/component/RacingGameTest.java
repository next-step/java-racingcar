package racing.component;

import org.junit.BeforeClass;
import org.junit.Test;
import racing.dto.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {


    static int testNum = 3;
    /**
     * Class변수 선언시 beforeMethod 동작 여
     */
    static RacingGame rg;
    static List<Car> cars;

    @BeforeClass
    public static void beforeMethod(){
        String[] carNames = {"lamborghini","test"};
        rg = new RacingGame( carNames);
        cars =  Arrays.asList(new Car(testNum,"test1"),new Car(testNum+1,"test2"),new Car(testNum+2,"test3"));
    }

    @Test
    public void 객체생성자테스트() {

        assertThat(rg.getCars()).hasSize(2);

    }

    @Test
    public void 자동차포지션확인테스트() {
        cars.get(0).countPosition(5);
        assertThat(cars.get(0).getPosition()).isEqualTo(++testNum);
    }

    @Test
    public void 자동차위치변화테스트() {
        for(Car c : cars){
            int temp = c.getPosition();
            c.countPosition(5);
            assertThat(c.getPosition()).isEqualTo(++temp);
        }
    }

    @Test
    public void 최대값_스트림_테스트() {
        int i = 0;
        for (Car c : cars){
            i = Math.max(i,c.getPosition());
        }
        assertThat(RacingGame.maxPostion(cars)).isEqualTo(i);
    }

    @Test
    public void 우승자_그룹_출력() {
        List<Car> cars = Arrays.asList(new Car(3,"test1"),new Car(4,"test2"),new Car(5,"test3"));
        List<Car> wCars = RacingGame.racingWinners(cars);

        assertThat(wCars.size()).isEqualTo(1);
    }

}