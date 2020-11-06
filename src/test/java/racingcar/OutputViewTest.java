package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import racingcar.domain.model.Car;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.ProceedStrategy;
import racingcar.view.OutputView;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("View 클래스 테스트")
class OutputViewTest {

    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = OutputView.getInstance();
    }

    @ParameterizedTest
    @DisplayName("car 가 움직인만큼 -가 출력되어야 한다.")
    @CsvSource(value = {"0$고정완 : -", "1$고정완 : --", "2$고정완 : ---", "3$고정완 : ----", "4$고정완 : -----", "5$고정완 : ------", "6$고정완 : -------"}, delimiter = '$')
    void convertCarPositions(int loop, String expectedResult) {
        String name = "고정완";
        MoveStrategy strategy = ProceedStrategy.getInstance();
        Car car = Car.createCar(name, strategy);

        for (int i = 0; i < loop; i++) {
            car.move();
        }

        String result = outputView.convertCar(car);
        assertThat(result)
                .isEqualTo(expectedResult);

    }

    @ParameterizedTest
    @DisplayName("convertWinnerList 테스트")
    @CsvSource(value = {"1,2,3$1, 2, 3가 최종 우승했습니다.", "a,b,c$a, b, c가 최종 우승했습니다."}, delimiter = '$')
    void convertWinnerList(String winnerNameCsv, String expectedMsg) {
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);

        String[] winnerNames = winnerNameCsv.split(",");
        List<Car> carList = new LinkedList<Car>();
        for (int i = 0; i < winnerNames.length; i++) {
            String name = winnerNames[i];
            Car car = Car.createCar(name, strategy);
            carList.add(car);
        }

        assertThat(outputView.convertWinnerList(carList))
                .isEqualTo(expectedMsg);
    }
}
