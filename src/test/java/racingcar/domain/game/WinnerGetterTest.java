package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerGetterTest {

    WinnerGetter winnerGetter;
    Cars cars;

    @BeforeEach
    void setUp(){
        winnerGetter = new WinnerGetter();
        cars = new Cars(4);
    }

    @Test
    @DisplayName("우승자 하나 있을 때 정확한 우승자를 가져오는지 테스트")
    void winnerTest(){
        cars.getCarList().get(0).forward(1);
        List<Car> winners = winnerGetter.getWinnerCars(cars);
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 여러명 있을 때 우승자 리스트 가져오는지 테스트")
    void multipleWinnerTest(){
        cars.getCarList().get(0).forward(1);
        cars.getCarList().get(1).forward(1);
        List<Car> winners = winnerGetter.getWinnerCars(cars);
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getPosition()).isEqualTo(1);
        assertThat(winners.get(1).getPosition()).isEqualTo(1);
    }
}