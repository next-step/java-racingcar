package step4.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.racing.domain.Car;
import step4.racing.domain.RacingGame;
import step4.racing.domain.RacingInfo;
import step4.racing.move.RandomMove;
import step4.racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainTest {

    private List<Car> cars;
    private List<Car> winnerCars = new ArrayList<>();
    private Car car;
    private Car car1;
    private Car car2;
    private Car car3;
    private ResultView resultView;
    private RacingGame racingGame;
    private RacingInfo racingInfo;
    private RandomMove randomMove;

    @BeforeEach
    void setUp() {
        racingInfo = new RacingInfo("강푸름,김빨강,최초록",3);
        racingGame = new RacingGame(racingInfo);
        resultView = new ResultView(racingGame, racingInfo);
        randomMove = new RandomMove();

        cars = new ArrayList<>();
        car = new Car("이노랑", 1);
        car1 = new Car("강푸름", 15);
        car2 = new Car("김빨강", 10);
        car3 = new Car("최초록", 9);

        winnerCars = new ArrayList<>();

        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

    }

    @DisplayName("자동차 이동")
    @Test
    void moveCar() {
        car.moveCarPosition();
        assertThat(car.getPosiotion()).isEqualTo(2);
        car1.moveCarPosition();
        assertThat(car1.getPosiotion()).isEqualTo(16);
    }

    @DisplayName("자동차 이동 조건 테스트")
    @Test
    void movableTest() {
        assertThat(randomMove.isTestMovable()).isEqualTo(true);
    }

    @DisplayName("자동차 이동값중 가장 큰 값 구하기")
    @Test
    void maxPositionTest() {
        assertThat(resultView.getMaxPosition(cars)).isEqualTo(15);
    }

    @DisplayName("우승자 확인")
    @Test
    void winnerCheck() {
        int maxPosition = resultView.getMaxPosition(cars);
        winnerCars = resultView.getWinner(cars,maxPosition,winnerCars);
        assertThat(resultView.printWinners(winnerCars)).isEqualTo("최종 우승자는 강푸름 입니다.");
    }

/*


*/
}
