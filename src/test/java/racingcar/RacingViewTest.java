package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("View 클래스 테스트")
class RacingViewTest {

    private RacingView racingView;

    @BeforeEach
    void setUp() {
        RacingGame game = Mockito.mock(RacingGame.class);
        this.racingView = new RacingView(game);
    }

    @ParameterizedTest
    @DisplayName("car 가 움직인만큼 -가 출력되어야 한다.")
    @CsvSource(value = {"0$고정완 : -", "1$고정완 : --", "2$고정완 : ---", "3$고정완 : ----", "4$고정완 : -----", "5$고정완 : ------", "6$고정완 : -------"}, delimiter = '$')
    void convertCarPositions(int loop, String expectedResult) {
        String name = "고정완";
        MoveStrategy strategy = () -> true;
        Car car = new Car(name, strategy);

        for (int i = 0; i < loop; i++) {
            car.move();
        }

        String result = this.racingView.convertCar(car);
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
            carList.add(new Car(name, strategy));
        }

        assertThat(this.racingView.convertWinnerList(carList))
                .isEqualTo(expectedMsg);
    }
}
