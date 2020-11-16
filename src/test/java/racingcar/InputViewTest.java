package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InputViewTest {

    @Test
    void input_test() {
        String test = "summer,moon";
        System.out.println(Arrays.toString(test.split(",")));
    }
}
