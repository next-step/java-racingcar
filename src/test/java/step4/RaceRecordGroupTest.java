package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.dto.Car;
import step4.dto.CarName;
import step4.dto.RaceRecord;
import step4.dto.RaceRecordGroup;

import java.util.Arrays;

class RaceRecordGroupTest {

    @Test
    @DisplayName("get 메서드는 불변한 컬렉션을 반환한다")
    public void unmodifiableTest() {
        RaceRecordGroup raceRecordGroup = new RaceRecordGroup();
        raceRecordGroup.addRaceRecord(new RaceRecord(Arrays.asList(new Car(new CarName("poby")))));

        Assertions.assertThatThrownBy(() -> {
            raceRecordGroup.getRaceRecordGroup().remove(0);
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
