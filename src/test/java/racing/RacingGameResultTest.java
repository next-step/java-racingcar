package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.RacingGameResult;
import racing.domain.AlwaysMoveMovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 게임 결과 클래스 테스트")
class RacingGameResultTest {

    @Test
    @DisplayName("RacingGameResult과 RacingGameResult 생성자 파라미터의 결과가 같은지 테스트")
    void racingResultTest() {
        List<Car> carList = Arrays.asList(new Car("test1"), new Car("test2"), new Car("test3"));

        Cars cars = new Cars();
        for (Car car : carList) {
            car.move(new AlwaysMoveMovingStrategy());
            cars.addCar(car);
        }

        RacingGameResult result = new RacingGameResult();
        result.addResult(cars);

        Cars round1Cars = result.getAllRoundCars().get(0);
        List<Car> carList1 = round1Cars.getCars();

        List<Car> carList2 = cars.getCars();
        int carCount = carList2.size();

        for (int i = 0; i< carCount; i++) {
            assertThat(carList2.get(0).getPosition()).isEqualTo(carList1.get(i).getPosition());
        }
    }

    @Test
    @DisplayName("우승자가 제대로 나오는지 테스트 테스트")
    void getWinnersTest() {
        String winnerName = "test1";
        List<Car> carList = Arrays.asList(new Car(winnerName), new Car("test2"), new Car("test3"));

        Cars cars = new Cars();
        for (Car car : carList) {
            if (winnerName.equals(car.getName())) {
                car.move(new AlwaysMoveMovingStrategy());
            }
            cars.addCar(car);
        }

        RacingGameResult result = new RacingGameResult();
        result.addResult(cars);

        List<Car> winners = result.getWinners();

        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo(winnerName);
    }
}