package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingcarTest {

    @DisplayName("입력한 자동차 이름이 5자를 넘어갈 수 없다.")
    @Test
    void nameCheckTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car("poby123", 0);
        });
    }

    @DisplayName("0~9사이의 무작위 값을 뽑아 4이상이면 자동차를 움직일 수 있다")
    @Test
    void isMoveTest(){
        Car car = new Car("poby", 0);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 경주를 해서 가장 많이 움직인 자동차 위치를 구할수 있다.")
    @Test
    void getMaxPositionTest(){
        RacingGame racingGame = new RacingGame();
        WinnerExtraction winnerExtraction = new WinnerExtraction();
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 4);
        Car car3 = new Car("car3", 5);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        assertThat(winnerExtraction.getMaxPosition(carList)).isEqualTo(5);
    }

    @DisplayName("가장 많이 움직인 자동차를 알 수 있다")
    @Test
    void getWinnersTest(){
        RacingGame racingGame = new RacingGame();
        WinnerExtraction winnerExtraction = new WinnerExtraction();
        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("car1", 1);
        Car car2 = new Car("car2", 4);
        Car car3 = new Car("car3", 5);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        int maxPosition = 5;
        List<Car> winners = winnerExtraction.getWinners(carList, maxPosition);

        for(Car winner : winners){
            assertThat(winner.getCarName()).isEqualTo("car3");
        }

    }

}
