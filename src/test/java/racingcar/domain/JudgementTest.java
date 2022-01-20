package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        Assertions.assertThat(judgement.judge(cars)).isEqualTo("최종 우승자: java");
    }

}