package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RacingGameResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 게임 결과 클래스 테스트")
class RacingGameResultTest {

    @Test
    @DisplayName("자동차 3대 각각의 위치를 RacingGameResult에서 받았을때 똑같은 결과가 나오는지 테스트")
    void racingResultTest() {

        List<Car> carList = Arrays.asList(new Car("test1"), new Car("test2"), new Car("test3"));

        RacingCars racingCars = new RacingCars();
        for (Car car : carList) {
            car.move(4);
            racingCars.addCar(car);
        }

        RacingGameResult result = new RacingGameResult();
        result.addResult(racingCars);
        List<Car> carList2 = racingCars.getCarList();
        int carCount = carList2.size();
        RacingCars round1RacingCars = result.getAllRoundRacingCars().get(0);
        List<Car> carList1 = round1RacingCars.getCarList();

        for (int i = 0; i< carCount; i++) {
            assertThat(carList2.get(0).getPosition()).isEqualTo(carList1.get(i).getPosition());
        }
    }
}