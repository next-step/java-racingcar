package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRecordTest {

    @Test
    @DisplayName("차 위치를 기록한다.")
    void createCarRecord() {
        String name = "abc";
        int location = 5;
        Car car = new Car(name, location);

        CarRecord carRecord = CarRecord.of(car);

        assertThat(carRecord.getName()).isEqualTo(name);
        assertThat(carRecord.getLocation()).isEqualTo(location);
    }

    @Test
    @DisplayName("차위치를 출력할 포맷을 리턴한다.")
    void getPrintRecordFormat() {
        String name = "abc";
        int location = 5;
        Car car = new Car(name, location);
        CarRecord carRecord = CarRecord.of(car);

        String recordFormat = carRecord.getPrintRecordFormat();

        assertThat(recordFormat).isEqualTo("abc : -----");
    }
}
