package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ResultTest {
    Result result;

    Cars cars;

    @BeforeEach
    void init() {
        result = new Result();
        cars = new Cars(new String[]{"test0", "test1", "test2"});
    }

    @Test
    void 우승자_찾기() {
        Car car = cars.getCar(0);
        car.moveOrStop(5);

        assertThat(result.findWinner(cars)).containsExactly("test0");
    }
}
