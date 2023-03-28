package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    @DisplayName("4이상의 값으로 모두 전진해서 전부가 이기는지 테스트")
    @ParameterizedTest
    @CsvSource(value = "pobi,woni,jun | 5", delimiter = '|')
    void racingCar(String participant, Integer trial) {
        ArrayList<Car> cars = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(participant, ",");
        while (stringTokenizer.hasMoreTokens()) {
            cars.add(new Car(stringTokenizer.nextToken()));
        }

        cars.get(0).step(2);
        cars.get(1).step(6);
        cars.get(1).step(6);
        cars.get(1).step(6);
        cars.get(1).step(6);
        cars.get(1).step(6);
        cars.get(1).step(6);
        cars.get(2).step(5);

        ResultView.printCars(cars);

        RacingCar racingCar = new RacingCar(cars, trial);

        List<Car> winners = racingCar.getWinner();
        ResultView.showWinner(cars);
        assertThat(winners.get(0).getName()).isEqualTo("woni");
    }
}
