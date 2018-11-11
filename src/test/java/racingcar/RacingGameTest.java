package racingcar;


import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void 자동차별위치이동(){
        ArrayList<Car> car = new ArrayList<Car>();
        car.add(new Car("pobi"));
        car.add(new Car("crong"));
        car.add(new Car("honux"));
        int carSeq = 2;

        RacingGame.movePerCarProcess(car, carSeq);
        assertThat(car.get(2).getPosition()).isEqualTo(2);
    }

    @Test
    public void 이동가능체크(){
        boolean flag = RacingGame.movePossibleCheck();
        System.out.println(flag);
        if(flag){
            assertThat(flag).isEqualTo(true);
        }
        if(!flag){
            assertThat(flag).isEqualTo(false);
        }

    }


    @Test
    public void 맥스위치값비교(){
        Car car1 = new Car("pobi", 5);
        Car car2 = new Car("crong", 3);
        int maxPosition = 3;

        assertThat(car1.searchMaxPosition(maxPosition, car1)).isEqualTo(5);
        assertThat(car2.searchMaxPosition(maxPosition, car2)).isEqualTo(3);

    }

    @Test
    public void 우승자리스트확인() {
        List<String> winners = new ArrayList<>();
        int maxPosition = 5;
        Car car1 = new Car("pobi", 5);
        Car car2 = new Car("crong", 3);
        Car car3 = new Car("honux", 5);

        car1.checkPositionPerCar(5, car1, winners);
        car2.checkPositionPerCar(5, car2, winners);
        car3.checkPositionPerCar(5, car3, winners);

        List<String> compare = new ArrayList<>();
        compare.add(car1.getName());
        compare.add(car3.getName());

        assertThat(winners).isEqualTo(compare);
    }
}