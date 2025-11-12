package study.racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinnerTest {
    private static final int MOVABLE_NUMBER = 5;

    @Test
    void 우승자가_한명이면_우승자를_반환한다() {
        Car car1 = Car.of("yang", 1);
        Car car2 = Car.of("pobi", 0);

        List<Car> cars = Arrays.asList(car1, car2);
        Winners winners = Winners.from(cars);
        List<String> names = winners.getNames();

        assertEquals(1, names.size());
        assertEquals("yang", names.get(0));
    }

    @Test
    void 우승자가_여러명이면_모든우승자를_반환한다() {
        Car car1 = Car.of("yang", 1);
        Car car2 = Car.of("pobi", 1);

        List<Car> cars = Arrays.asList(car1, car2);
        Winners winners = Winners.from(cars);
        List<String> names = winners.getNames();

        assertEquals(2, names.size());
        assertTrue(winners.getNames().contains("yang"));
        assertTrue(winners.getNames().contains("pobi"));
    }

}
