package domain;

import io.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ResultViewTest {
    @ParameterizedTest
    @CsvSource(value = {"1,owner : -", "3,owner : ---", "4,owner : ----"}, delimiter = ',')
    @DisplayName("printCar()은 distance의 수만큼 -를 출력한다.")
    void printCar(int distance, String expected) {
        Car car = new Car("owner", new AlwaysMoveStrategy());
        for (int i = 1; i <= distance; i++) {
            car.move();
        }
        assertThat(ResultView.getCarAsString(car)).isEqualTo(expected);
    }

}