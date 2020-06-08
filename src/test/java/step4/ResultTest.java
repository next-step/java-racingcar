package step4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void create() {
        List<Car> list = new ArrayList<>();
        list.add(Car.of("peter"));
        list.add(Car.of("kassie"));
        list.add(Car.of("oak"));
        Result result = new Result(list);
        assertThat(result).isEqualTo(new Result(list));
    }
}
