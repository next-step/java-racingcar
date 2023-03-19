package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.domain.Car;
import racingCar.domain.RacingCar;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.ArrayList;
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

        RacingCar racingCar = new RacingCar(trial, 5);

        racingCar.setWinner(cars);
        ResultView.showWinner(cars);
        assertThat(ResultView.showWinner(cars)).isEqualTo(new String("최종 우승자 : [woni]"));
    }
}
