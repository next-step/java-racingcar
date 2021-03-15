package step4.domain.driver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import step4.domain.driver.car.Car;
import step4.domain.driver.name.Name;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    private final int MINIMUM = 0;
    private final int MAXIMUM = 5;

    @DisplayName("Driver 클래스의 move()에 true 값이 주어졌을 때 값이 증가되는지 테스트")
    @RepeatedTest(value = 10, name = "현재 Loop : {0}")
    void move_ValidationValue_TURE() {
        // given
        Name driverName = Name.from("김우재", name -> MINIMUM <= name.length() && name.length() <= MAXIMUM);
        Car drivingCar = Car.newInstance();
        Driver driver = Driver.from(driverName, drivingCar);

        // when
        driver.move(() -> true);
        int actual = driver.getStatus();

        // then
        assertThat(actual).isEqualTo(1);
    }

}
