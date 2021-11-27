package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.dto.Car;
import step5.dto.CarName;
import step5.domain.RaceRecord;

import java.util.ArrayList;
import java.util.List;

class RaceRecordTest {
    private List<Car> cars;
    private RaceRecord raceRecord;

    @BeforeEach
    private void setCars() {
        cars = new ArrayList<>();
        cars.add(new Car(new CarName("poby")));
        cars.add(new Car(new CarName("rian")));
        cars.add(new Car(new CarName("kero")));

        raceRecord = new RaceRecord(cars);
    }

    @Test
    @DisplayName("get 메서드는 불변한 컬렉션을 반환한다")
    public void unmodifiableTest() {
        Assertions.assertThatThrownBy(() -> {
            raceRecord.getRaceRecord().remove(0);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("우승자를 찾는 메서드는 우승자 수만큼 반환한다")
    public void winnderCount() {
        Assertions.assertThat(raceRecord.findWinners()).hasSize(3);
    }
}
