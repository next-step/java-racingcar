package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.exception.CarRaceCheckInputException;
import step3.view.InputView;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputViewTest {

    @ParameterizedTest
    @DisplayName("자동차 입력 값 0 이하 입력")
    @CsvSource(value = {"0,1", "0,5", "0,2", "-1,20", "-4,10"})
    public void inputCarCountTest(int carCount, int racingCount){
        assertThatExceptionOfType(CarRaceCheckInputException.class)
                .isThrownBy(()->{new InputView().saveInputData(carCount, racingCount);});
    }

    @ParameterizedTest
    @DisplayName("시도할 횟수 입력 값 0 이하 입력")
    @CsvSource(value = {"1,0", "4,0", "8,0", "1,0", "4,0"})
    public void inputRacingCountCarTest(int carCount, int racingCount){
        assertThatExceptionOfType(CarRaceCheckInputException.class)
                .isThrownBy(()->{new InputView().saveInputData(carCount, racingCount);});
    }


}
