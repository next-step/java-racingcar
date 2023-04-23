package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultViewTest {

    ResultView resultView = new ResultView();

    @DisplayName("차량 위치에 맞게 상태 이미지를 출력한다.")
    @ParameterizedTest
    @CsvSource(value = {"A:2", "B:5", "C:0"}, delimiter = ':')
    public void print_car_state(String carName, int position) throws Exception {
        Car car = new Car(carName, position);
        assertThat(resultView.printCarPosition(car.getPosition()))
                .isEqualTo("-".repeat(position));
    }


}
