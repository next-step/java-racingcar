package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgementTest {
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car("c", 3));
        cars.add(new Car("java", 4));
        cars.add(new Car("jpa", 1));
    }

    @Test
    void winnerTest() {
        Judgement judgement = Judgement.of();
        assertThat(judgement.judge(cars)).isEqualTo("최종 우승자: java");
    }

    @Test
    void tieBreakerTest() {
        Judgement judgement = Judgement.of();
        cars.add(new Car("jUnit", 4));
        assertThat(judgement.judge(cars)).isEqualTo("최종 우승자: java,jUnit");
    }

}