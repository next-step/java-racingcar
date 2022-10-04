package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultTest {
    Result result;

    List<Car> cars;

    @BeforeEach
    void init() {
        result = new Result();
        cars = new ArrayList<>();
        cars.add(new Car("test0", new Position()));
        cars.add(new Car("test1", new Position()));
        cars.add(new Car("test2", new Position()));

    }

    @Test
    void test() {
        result.findWinner(cars);
    }
}
