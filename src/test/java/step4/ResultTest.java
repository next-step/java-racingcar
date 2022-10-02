package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ResultTest {
    Result result;
    Map<String, Integer> resultMap = new HashMap<>();

    @BeforeEach
    void init() {
        result = new Result();
        resultMap.put("test1", 3);
        resultMap.put("test2", 4);
        resultMap.put("test3", 5);
        resultMap.put("test4", 3);
        resultMap.put("test5", 5);

    }

    @Test
    void test() {
        result.findWinner(resultMap);
        Assertions.assertThat(result.getWinner()).containsExactly("test5", "test3");
    }
}
