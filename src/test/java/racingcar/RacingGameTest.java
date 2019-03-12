package racingcar;

import org.junit.Before;
import org.junit.Test;
import racingcar.car.Car;
import racingcar.race.RacingGame;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    //1. Test를 위해 RacingGame 클래스에 getter를 만들었는데, 이렇게 해도 되는건가요?
        // > 인스턴수 변수에 대한 getter, setter 생성 X
    //2. return type이 void인 method에 대해서는 Test를 어떻게 만들어야하는지 잘 모르겠습니다.
        // > return type이 void가 된 구조에 대해 생각해보고, 구조 개선

    //3. class에 private method가 있다면 어떻게 테스트하는게 좋을까요?
        // > private Method 테스트는 public Method 테스트를 통해 커버

    //19.03.10 - step1 피드백, 개선한 구조에 맞게 테스트 method 수정


    RacingGame racingGame;
    private List<Car> cars = null;

    @Before
    public void setUp() throws Exception {

        cars = new ArrayList<Car>();

        Car car1 = new Car("po", 0);
        Car car2 = new Car("jo", 0);
        Car car3 = new Car("gu", 0);
        Car car4 = new Car("yo", 0);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @Test
    public void 모든차량_1회_게임_확인() {

        racingGame = new RacingGame(1);
        int topPosition = racingGame.game(cars);
        assertThat(topPosition).isBetween(0, 1);
    }

    @Test
    public void 레이싱_게임_3대_5회() {
        racingGame = new RacingGame(5);
        int topPosition = racingGame.game(cars);
        assertThat(topPosition).isBetween(0, 5);
    }
}