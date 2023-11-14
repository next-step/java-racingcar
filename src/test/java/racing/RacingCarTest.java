package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    @Test
    void moveSuccessTest(){
        Car car = new Car();
        car.turn(new MovableNumberGenerator());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveFailTest(){
        Car car = new Car();
        car.turn(new NotMovableNumberGenerator());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest()
    @CsvSource(value = {"3, 5", "2, 5"})
    void raceTest(int carCount, int tryCount){
        Racing racing = new Racing(carCount);
        for(int i=0; i<tryCount; i++){
            racing.roundStart();
        }
        List<Car> carList = racing.getCarList();
        assertThat(carList.size()).isEqualTo(carCount);
        assertThat(carList).allSatisfy(car -> {
            assertThat(car.getPosition()).isNotNegative().isLessThanOrEqualTo(tryCount);
        });
    }

    @Test
    void carNameTest(){
        String carNameList = "aaa,bb,cccc";
        assertThat(InputView.getSplitCarNames(carNameList)).isEqualTo(new String[]{"aaa", "bb", "cccc"});
    }

    @Test
    void carNameValidationTest(){
        String carNameList = "aaaaaa,bb,cccc";
        assertThatThrownBy(() -> InputView.getSplitCarNames(carNameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 허용 길이를 초과하였습니다.");
    }

    @Test
    void racingWinnerTest(){
        Car car_one = new Car("aaa");
        Car car_two = new Car("bb");
        Car car_three = new Car("cccc");

        car_one.move();
        car_two.move();

        assertThat(ResultView.getWinnersName(Arrays.asList(car_one, car_two, car_three)))
                .isEqualTo(Arrays.asList("aaa", "bb"));
    }
}
