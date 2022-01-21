package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.movable.ForwardStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgementTest {
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car("c", new ForwardStrategy(), 3));
        cars.add(new Car("java", new ForwardStrategy(), 4));
        cars.add(new Car("jpa", new ForwardStrategy(), 1));
    }

    @Test
    void winnerTest() {
        Judgement judgement = Judgement.of();
        assertThat(judgement.judge(cars)).isEqualTo("최종 우승자: java");
    }

    @Test
    void tieBreakerTest() {
        Judgement judgement = Judgement.of();
        cars.add(new Car("jUnit", new ForwardStrategy(), 4));
        assertThat(judgement.judge(cars)).isEqualTo("최종 우승자: java,jUnit");
    }

    @Test
    void noWinnerTest() {
        Judgement judgement = Judgement.of();
        cars = new ArrayList<>();

        cars.add(new Car("c", new ForwardStrategy(), 0));
        cars.add(new Car("java", new ForwardStrategy(), 0));
        cars.add(new Car("jpa", new ForwardStrategy(), 0));

        assertThat(judgement.judge(cars)).isEqualTo("우승자는 없습니다.");
    }

}