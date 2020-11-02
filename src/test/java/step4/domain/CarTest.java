package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
public class CarTest {
    Car car = new Car(0);

    @DisplayName("자동차가 움직이면 position이 증가")
    @Test
    public void increasePosition() {
        car.move();

        Integer position = car.getPosition();

        assertThat(position).isEqualTo(1);
    }

    @DisplayName("자동차 위치가 기록됨")
    @Test
    public void recordPosition() {
        car.record();

        Integer recordCount = car.getRecordCount();

        assertThat(recordCount).isEqualTo(1);
    }
}