package study.step4;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step4.model.Car;

public class RacingWinnerTest {
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void init(){
        car1 = new Car("test1");
        car2 = new Car("test2");
        car3 = new Car("test3");
    }

    @ParameterizedTest(name = "우승자 판정 테스트")
    @CsvSource(value = {"1,2,3:test3", "2,3,2:test2", "2,2,1:test1,test2"}, delimiter = ':')
    void WinnerTest(String input, String expect) {
        List<Car> carList = new ArrayList<>();
        String[] distance = input.split(",");
        car1.move(Integer.parseInt(distance[0]));
        car2.move(Integer.parseInt(distance[1]));
        car3.move(Integer.parseInt(distance[2]));
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        RacingWinner racingWinner = new RacingWinner();
        racingWinner.determineWinners(carList);
        List<String> expectWinners = Arrays.asList(expect.split(",").clone());
        List<String> winnerNames = racingWinner.getWinnerNames();
        assertThat(winnerNames).isEqualTo(expectWinners);
    }
}
