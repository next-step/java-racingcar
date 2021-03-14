package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    ResultView resultView = new ResultView();

    @Test
    @DisplayName("현재 위치 표현 테스트")
    void getLocationView() {
        //given
        int expectLocation = 3;
        Car testCar = new Car(expectLocation);
        String expectLocationView = "---";

        //when
        String result = resultView.getLocationView(testCar);


        //then
        assertThat(result).isEqualTo(expectLocationView);

    }
}
