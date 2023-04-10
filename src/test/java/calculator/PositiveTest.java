package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveTest {

    //getter 없이 잘 만들어졌는지 테스트
    @Test
    void create() {
        Positive positive = new Positive("3");
        Assertions.assertThat(positive.getNumber()).isEqualTo(3);
    }
}
