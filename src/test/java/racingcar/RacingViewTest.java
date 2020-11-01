package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("View 클래스 테스트")
class RacingViewTest {

    private RacingView racingView;
    private String name = "고정완";

    @BeforeEach
    void setUp() {
        RacingGame game = Mockito.mock(RacingGame.class);
        this.racingView = new RacingView(game);
    }

    @ParameterizedTest
    @DisplayName("car 가 움직인만큼 -가 출력되어야 한다.")
    @CsvSource(value = {"0$고정완 : -", "1$고정완 : --", "2$고정완 : ---", "3$고정완 : ----", "4$고정완 : -----", "5$고정완 : ------", "6$고정완 : -------"}, delimiter = '$')
    void convertCarPositions(int loop, String expectedResult) {
        MoveStrategy strategy = new MoveStrategy() {
            @Override
            public boolean checkMovable() {
                return true;
            }
        };
        Car car = new Car(this.name, strategy);

        for (int i = 0; i < loop; i++) {
            car.move();
        }

        String result = this.racingView.convertCar(car);
        assertThat(result)
                .isEqualTo(expectedResult);

    }
}
