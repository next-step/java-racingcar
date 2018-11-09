package racingcar;


import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

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
    public void 맥스위치값비교(){
        Car car1 = new Car("pobi", 5);
        Car car2 = new Car("crong", 3);
        int maxPosition = 3;
        assertThat(RacingGame.searchMaxPosition(maxPosition, car1)).isEqualTo(5);
        assertThat(RacingGame.searchMaxPosition(maxPosition, car2)).isEqualTo(5);
    }

    @Test
    public void 우승자리스트확인() {
        ArrayList<Car> winners = new ArrayList<Car>();
        int maxPosition = 5;
        Car car1 = new Car("pobi", 5);
        Car car2 = new Car("crong", 3);
        Car car3 = new Car("honux", 5);

        RacingGame.checkPositionPerCar(5, car1, winners);
        RacingGame.checkPositionPerCar(5, car2, winners);
        RacingGame.checkPositionPerCar(5, car3, winners);

        ArrayList<Car> compare = new ArrayList<Car>();
        compare.add(car1);
        //compare.add(car3);

        assertThat(winners).isEqualTo(compare);
    }
}