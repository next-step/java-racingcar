package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static carracing.CarRacing.racingStart;

public class CarRacingTest {

    @Test
    @DisplayName("메인 기능 테스트")
    void main() {

        String carCount = "3";
        System.out.println("자동차 대수는 몇 대 인가요? : " + carCount);

        String tryCount = "5";
        System.out.println("시도할 회수는 몇 회 인가요? : " + tryCount);

        racingStart(carCount, tryCount);
    }

}
