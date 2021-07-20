package racing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static Car car;

    @BeforeAll
    static void setUp() {
        String carNumber = "4\n3\n";
        InputStream in1 = new ByteArrayInputStream(carNumber.getBytes());
        System.setIn(in1);

       /* String tryRacingNumber = "3\n";
        InputStream in2 = new ByteArrayInputStream(tryRacingNumber.getBytes());
        System.setIn(in2);*/

        car = new Car();
    }

    @Test
    @DisplayName("경주에 참가할 자동차 대수를 입력하면 대수만큼 자동차가 생성된다.")
    public void create_carModel() {
        car.car_racing();

        assertThat(car.getCarList()).extracting("carNumber").containsExactly(1, 2, 3, 4);
        assertThat(car.getCarList().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("랜덤 숫자 함수를 실행하면 0이상 10미만의 숫자가 생성된다.")
    public void create_random_number() {
        int result = car.randomIntValue();

        assertThat(result).isGreaterThan(0).isLessThan(10);
    }

    @Test
    @DisplayName("랜덤 숫자가 4이상이면 경주에 사용되는 자동차가 전진한다.")
    public void racing_random_number_check() {
        String raceDistance1 = car.getRaceDistance(4);
        String raceDistance2 = car.getRaceDistance(3);

        assertThat(raceDistance1).isEqualTo("-");
        assertThat(raceDistance2).isEqualTo("");
    }

    @Test
    @DisplayName("경주 시도 횟수만큼 참가한 차는 경주를 진행한다.")
    public void racingByCar() {
        car.car_racing();
        
    }
}
