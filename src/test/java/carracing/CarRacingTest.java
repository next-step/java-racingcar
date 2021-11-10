package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static carracing.CarRacing.process;

public class CarRacingTest {

    @Test
    @DisplayName("메인 테스트")
    void mainProcess() {

        String carCount = "3";
        System.out.println("자동차 대수는 몇 대 인가요? : " + carCount);

        String tryCount = "5";
        System.out.println("시도할 회수는 몇 회 인가요? : " + tryCount);

        process(carCount, tryCount);
    }

    @Test
    @DisplayName("10개 자동차 전진 멈춤 테스트")
    void drivingCars() {
        List<Car> carList = new ArrayList<>();
        int carCount = 10;
        int drivingCount = 0;

        for(int i = 0; i < carCount; i++) {
            carList.add(new Car());
            carList.get(i).driving(i);
        }

        for (int i = 0; i < carCount; i++) {
            if (carList.get(i).getDrivingHistory().equals("-")) {
                drivingCount++;
            }
        }

        Assertions.assertThat(drivingCount).isEqualTo(6);
    }

    @Test
    @DisplayName("주행 조건 테스트")
    void drivingCondition() {
        Car car = new Car();
        String answer = "------";

        for (int i = 0; i < 10; i++) {
            car.driving(i);
        }

        Assertions.assertThat(car.getDrivingHistory()).isEqualTo(answer);
    }
}
