package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.helper.Judge;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {

    @DisplayName("우승자를 선정한다 우승자는 1명 이상이다.")
    @Test
    void test_winner() {
        Car hypem = new Car("hypem", 3);
        Car prodo = new Car("prodo", 2);
        Car sam = new Car("sam", 3);
        List<Car> cars = Arrays.asList(hypem, prodo, sam);

        Racing racing = new Racing(cars, 3);
        List<Car> winners = Judge.judgeWinners(cars);

        assertThat(winners).contains(hypem, sam);
        assertThat(winners).doesNotContain(prodo);
    }

}
