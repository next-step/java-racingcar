package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Cars;
import step3.exception.CarRaceCheckInputException;
import step3.view.ResultView;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CarRacingTest {

    @ParameterizedTest
    @DisplayName("자동차 3대, 시도할 횟수 5회 자동차 이동 확인")
    @CsvSource(value = {"3,5"})
    public void racingTest(int carCount, int racingCount){
        Cars cars = new Cars();
        ResultView resultView = new ResultView();
        cars.createCarList(carCount);
        cars.playGame(racingCount,resultView);
    }


    @ParameterizedTest
    @DisplayName("예외 입력값 입력후 자동차 경주")
    @CsvSource(value = {"0,5","10,0","0,0"})
    public void racingTest2(int carCount, int racingCount){
        Cars cars = new Cars();
        ResultView resultView = new ResultView();
        assertThatExceptionOfType(CarRaceCheckInputException.class)
                .isThrownBy(()->{
                    cars.createCarList(carCount);
                    cars.playGame(racingCount,resultView);
                });

    }

}
