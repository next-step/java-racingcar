package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.RaceException;

public class RaceTest {
    List<RacingCar> cars;

    List<RandomNumbers> randomNumbers;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new RacingCar("차1"));
        cars.add(new RacingCar("차2"));
        cars.add(new RacingCar("차3"));

        randomNumbers = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        r1.add(9);
        r1.add(1);
        List<Integer> r2 = new ArrayList<>();
        r2.add(5);
        r2.add(9);
        r2.add(1);
        randomNumbers.add(new RandomNumbers(r1));
        randomNumbers.add(new RandomNumbers(r2));
    }

    @Test
    void 경주_테스트() {
        Race race = new Race(2, new RacingCars(cars));

        race.startRace(randomNumbers);

        List<RacingCar> rs = new ArrayList<>();
        rs.add(new RacingCar("차1", 1));
        rs.add(new RacingCar("차2", 2));
        rs.add(new RacingCar("차3"));
        Race expected = new Race(2, new RacingCars(rs));

        assertThat(race).isEqualTo(expected);
    }

    @Test
    void 경기회수_에러_테스트() {
        assertThatThrownBy(() -> {
            Race race = new Race(0, new RacingCars(cars));
        }).isInstanceOf(RaceException.class)
                .hasMessageMatching("경기 회수는 1 이상의 수를 입력해주세요");
    }
}
