package racing.component;

import org.junit.BeforeClass;
import org.junit.Test;
import racing.dto.Car;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {


    static List<Car> cars = new ArrayList<Car>();
    static int testNum = 3;

    @BeforeClass
    public static void beforeMethod(){
        cars.add(new Car(testNum));
    }

    @Test
    public void 객체생성자테스트() {

        RacingGame rg = new RacingGame(1 ,5);

        assertThat(rg.getCars()).hasSize(1);

    }

    @Test
    public void 자동차포지션확인테스트() {

        cars.get(0).countPosition(5);
        assertThat(cars.get(0).getPosition()).isEqualTo(++testNum);
    }

    @Test
    public void 자동차위치변화테스트() {
        for(Car c : cars){
            c.countPosition(5);
            assertThat(c.getPosition()).isEqualTo(++testNum);
        }
    }
}