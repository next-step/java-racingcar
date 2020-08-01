package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 객체 TEST")
class CarTest {
    Input input;

    @BeforeEach
    void setUp() {
        input = Input.of(1, 1);
    }

    @DisplayName("경기기록이 있는 레이싱차 TEST")
    @Test
    void ofRacingCarReady() {
        List<Car> cars = Car.ofRacingCarReady(input);
        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars.get(0)
                       .getCarRaceRecords().get(0)
                       .getMyLocation())
            .isEqualTo(1);
    }

    @DisplayName("경기기록 생성")
    @Test
    void ofRaceCarRecord() {
        assertThat(Car.ofRaceCarRecord(input.getTotalLaps())
                      .getCarRaceRecords().get(0)
                      .getMyLocation())
            .isEqualTo(1);
    }
}