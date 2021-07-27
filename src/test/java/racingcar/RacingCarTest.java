package racingcar;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.ui.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("우승자 확인")
    void winnersTest(){
        String[] carStrArr = Arrays.array("pobi", "crong", "honux");
        Cars cars = new Cars(carStrArr);
        List<Car> carsList = cars.getCars();
        Car winnerCar = carsList.get(0);
        Car winnerCar1 = carsList.get(1);
        for(int i=0; i<3; i++){
            winnerCar.move(4);
            winnerCar1.move(4);
        }
        Winners winners = new Winners(cars);
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        assertThat(winners.getWinnerNames()).contains(pobi.getName(),crong.getName());
    }

    @Test
    @DisplayName("게임 테스트")
    void playTest(){
        String winners = racingCar.play("pobi,crong,honux", 5);
        ResultView.printWinners(winners);
    }
}
