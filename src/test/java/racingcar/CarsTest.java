package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    @BeforeEach
    void setUp(){
        cars = new Cars(new String[]{"철수", "영희"});
        cars.getCarList().get(0).move();
        cars.getCarList().get(0).move();
        cars.getCarList().get(0).move();
        cars.getCarList().get(0).recordDistance();

        cars.getCarList().get(1).move();
        cars.getCarList().get(1).move();
        cars.getCarList().get(1).recordDistance();
    }

    @Test
    @DisplayName("최고 기록 테스트")
    public void bestRecordTest(){
        assertThat(cars.getBestRecord()).isEqualTo(3);
    }


    @Test
    @DisplayName("우승자 찾기 테스트")
    public void findWinnerTest(){

        List<String> winners = cars.findWinner();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("철수");
    }

}
