package racing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @BeforeAll
     static void setUp(){
        String carNumber = "4\n";
        InputStream in = new ByteArrayInputStream(carNumber.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("경주에 참가할 자동차 대수를 입력하면 대수만큼 자동차가 생성된다.")
    public void create_carModel(){
        Car car = new Car();
        car.car_racing();

        assertThat(car.getCarList()).extracting("carNumber").containsExactly(1, 2, 3, 4);
        assertThat(car.getCarList().size()).isEqualTo(4);
    }
}
