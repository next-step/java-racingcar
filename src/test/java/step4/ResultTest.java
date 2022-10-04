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

    Cars cars;

    @BeforeEach
    void init() {
        result = new Result();
        cars = new Cars();
        cars.addCars(new String[]{"test0", "test1", "test2"});
    }

    @Test
    void test() {
        result.findWinner(cars);
    }
}
