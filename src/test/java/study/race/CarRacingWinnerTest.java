package study.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarRacingWinnerTest {

    @Test
    @DisplayName("최대값 테스트")
    void getMaxTest(){
        Car car = new Car("Test1",10);
        assertThat(car.max(9)).isEqualTo(10);
        assertThat(car.max(11)).isEqualTo(11);
    }

    @Test
    @DisplayName("우승자 최대값 테스트")
    void  checkMaxPositionTest(){
        Car pobi = new Car("pobi", 10);
        assertThat(pobi.winnerCheck(10)).isTrue();
        assertThat(pobi.winnerCheck(8)).isFalse();
    }

    @Test
    @DisplayName("우승자 테스트")
    void raceWinnerTest() {
        Car pobi = new Car("pobi", 10);
        Car conan = new Car("conan", 9);
        List<Car> winners = Winners.findWinner(Arrays.asList(pobi, conan));
        assertThat(winners).hasSize(1);
        assertThat(winners).contains(pobi);
    }

}
