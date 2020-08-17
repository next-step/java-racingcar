package racing.car.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.MovableRule;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("park", "lee", "toto", "bibi"), 0);
    }

    @Test
    @DisplayName("레이싱 한 경기 후 결과 비교하")
    void racingOneGame() {
        // given
        MovableRule movableRule = () -> true;

        // when
        cars.racingOneGame(movableRule);

        // then
        assertThat(cars).isNotEqualTo(new Cars(Arrays.asList("park", "lee", "toto", "bibi"), 0));
    }

    @Test
    @DisplayName("trackrecords 생성하기")
    void getTrackRecords() {
        // given
        racingOneGame();
        Map<String, Integer> expectedTrackRecords = new LinkedHashMap<>();
        expectedTrackRecords.put("park", 1);
        expectedTrackRecords.put("lee", 1);
        expectedTrackRecords.put("toto", 1);
        expectedTrackRecords.put("bibi", 1);


        // when
        Map<String, Integer> trackRecords = cars.getTrackRecords();

        // then
        assertThat(trackRecords).isEqualTo(expectedTrackRecords);

    }

    @Test
    @DisplayName("우승자 찾기")
    void findWinner() {
        // given
        List<Car> expectedWinners = new ArrayList<>();
        expectedWinners.add(new Car("park", 0));
        expectedWinners.add(new Car("lee", 0));
        expectedWinners.add(new Car("toto", 0));
        expectedWinners.add(new Car("bibi", 0));

        // when
        List<Car> winners =  cars.findWinner();

        // then
        assertThat(winners).isEqualTo(expectedWinners);
    }
}