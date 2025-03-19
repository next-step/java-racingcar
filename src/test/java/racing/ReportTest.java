package racing;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReportTest {

    @Test
    @DisplayName("전달 받은 인덱스의 자동차의 위치를 반환한다.")
    void findPositionByIndexTest() {
        // given
        var carCount = 3;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            var car = new Car();
            moveCar(car, i);
            cars.add(car);
        }
        var report = new Report(cars);

        // when & then
        for (int i = 0; i < carCount; i++) {
            Assertions.assertThat(report.findPositionByIndex(i)).isEqualTo(i);
        }
    }

    private void moveCar(Car car, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            car.move(Car.MOVE_THRESHOLD + 1);
        }
    }
}
