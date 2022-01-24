package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.movable.RandomForwardStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgementTest {
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car("c", new RandomForwardStrategy(), 3));
        cars.add(new Car("java", new RandomForwardStrategy(), 4));
        cars.add(new Car("jpa", new RandomForwardStrategy(), 1));
    }

    @Test
    void winnerTest() {
        Judgement judgement = Judgement.instance();
        assertThat(judgement.judge(cars)).isEqualTo("최종 우승자: java");
    }

    @Test
    void tieBreakerTest() {
        Judgement judgement = Judgement.instance();
        cars.add(new Car("jUnit", new RandomForwardStrategy(), 4));
        assertThat(judgement.judge(cars)).isEqualTo("최종 우승자: java,jUnit");
    }

    @Test
    void noWinnerTest() {
        Judgement judgement = Judgement.instance();
        cars = new ArrayList<>();

        cars.add(new Car("c", new RandomForwardStrategy(), 0));
        cars.add(new Car("java", new RandomForwardStrategy(), 0));
        cars.add(new Car("jpa", new RandomForwardStrategy(), 0));

        assertThat(judgement.judge(cars)).isEqualTo("우승자는 없습니다.");
    }

}
