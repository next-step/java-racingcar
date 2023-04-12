package domain;

import io.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ResultViewTest {
    @ParameterizedTest
    @CsvSource(value = {"1:-", "3:---", "4:----"}, delimiter = ':')
    @DisplayName("printCar()은 distance의 수만큼 -를 출력한다.")
    void printCar(int distance, String expected) {
        Car car = new Car();
        for (int i = 1; i <= distance; i++) {
            car.move(10);
        }
        assertThat(ResultView.printCarDistance(car)).isEqualTo(expected);
    }

}