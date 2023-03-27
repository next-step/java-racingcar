package study.racingcartest.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import java.util.ArrayList;
import java.util.List;
import static racingcar.view.ResultView.printRace;

public class ResultViewTest {

    @Test
    @DisplayName("결과 출력하기")
    void printResult(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("cyan", 5));
        cars.add(new Car("vince", 3));
        cars.add(new Car("lucas", 2));
        printRace(cars, RacingCar.judgeWinner(cars));
    }
}
