package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    CarRacing carRacing;


    @DisplayName("차량 위치에 맞게 상태 이미지를 출력한다.")
    @ParameterizedTest
    @CsvSource(value = {"A:2", "B:5", "C:0"}, delimiter = ':')
    public void print_car_state(String carName, int position) throws Exception {
        assertThat(new Car(carName, position).printPosition())
                .isEqualTo(carName + " : " + "-".repeat(position));
    }

}
