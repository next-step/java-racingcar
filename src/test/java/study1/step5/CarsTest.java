package study1.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void createCarsTest(){
        String first_race = "first";
        String second_race = "second";
        String third_race = "third";

        String[] racerList = {first_race, second_race, third_race};

        Cars cars = new Cars("first,second,third");

        for(int i = 0; i < cars.getCarsSize(); i++){
            assertThat(cars.getCar(i)).isEqualTo(new Car(racerList[i], 1));
        }
    }
    @Test
    @DisplayName("라운드 진행 테스트")
    void raceTest(){
        String[] racerList = {"first", "second", "third"};

        Cars cars = new Cars("first,second,third");

        Decision moveGenerator = new FixedMoveDecision(10);

        int testCnt = 5;

        for(int i = 0; i < testCnt; i++){
            cars.race(moveGenerator);
        }

        // 검증
        for(int i =0;i < cars.getCarsSize(); i++){
            Car car = cars.getCar(i);
            assertThat(car.isBestRacer(testCnt+1)).isEqualTo(true);
        }
        Decision notMoveGenerator = new FixedMoveDecision(1);

        for(int i = 0; i < testCnt; i++){
            cars.race(notMoveGenerator);
        }

        for(int i =0;i < cars.getCarsSize(); i++){
            Car car = cars.getCar(i);
            assertThat(car.isBestRacer(testCnt+1)).isEqualTo(true);
        }

    }
}
