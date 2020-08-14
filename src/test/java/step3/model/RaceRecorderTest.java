package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.view.output.RaceRecorder;

import static org.assertj.core.api.Assertions.assertThat;

class RaceRecorderTest {

    @Test
    @DisplayName("문자열 저장 확인")
    void saveRecord() {
        RaceRecorder raceRecorder = new RaceRecorder();
        Car car = new Car("쌀국수");
        car.makeCarMove();
        car.makeCarMove();
        car.makeCarMove();

//        assertThat(raceRecorder.saveRecord(car)).contains("쌀국수").contains(RaceRecorder.MOVED_PRINTING);
    }
}