package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {

    @Test
    @DisplayName("우승자(distance가 가장 큰 Car 객체)를 구한다.")
    void getLeaders() {
        final Car pobi = new Car("pobi", 5);
        final Car crong = new Car("crong", 3);
        final Car honux = new Car("honux", 1);

        final Round round = new Round(Arrays.asList(pobi, crong, honux));

        final List<Car> expected = Arrays.asList(pobi);
        final List<Car> result = round.getLeaderList();

        // assert
        assertThat(result).containsAll(expected);
    }

    @Test
    @DisplayName("우승자(distance가 가장 큰 Car 객체)를 구한다. 한 명 이상일 수 있다.")
    void getLeaders2() {
        final Car pobi = new Car("pobi", 5);
        final Car crong = new Car("crong", 5);
        final Car honux = new Car("honux", 1);

        final Round round = new Round(Arrays.asList(pobi, crong, honux));

        final List<Car> expected = Arrays.asList(pobi, crong);
        final List<Car> result = round.getLeaderList();

        // assert
        assertThat(result).containsAll(expected);
    }
}
