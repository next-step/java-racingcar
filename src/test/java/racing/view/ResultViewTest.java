package racing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.behavior.CarMovable;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @DisplayName("자동차 이동 표시 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:-----", "2:--", "4:----"}, delimiter = ':')
    void printLocationByCar(final int location, final String result) {
        final Car car = new Car(location, new CarMovable());
        assertThat(ResultView.printLocationByCar(car)).isEqualTo(result);
    }
}
