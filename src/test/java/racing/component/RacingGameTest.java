package racing.component;

import org.junit.BeforeClass;
import org.junit.Test;
import racing.dto.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {


    static List<Car> cars = new ArrayList<Car>();
    static int testNum = 3;
    static RacingGame rg;

    @BeforeClass
    public static void beforeMethod(){
        cars.add(new Car(testNum,"test1"));
        cars.add(new Car(testNum,"test2"));
        cars.add(new Car(testNum,"test3"));


        String[] carNames = {"lamborghini","test"};
        rg = new RacingGame( carNames,5);
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
        List<Car> wCars = RacingGame.racingWinners(cars);
        int maxP = RacingGame.maxPostion(cars);
        int count = 0;
        for (Car c : cars){
            if(c.getPosition() == maxP){
                count ++;
            }
        }

        assertThat(wCars.size()).isEqualTo(count);
    }

}