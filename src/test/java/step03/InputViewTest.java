package step03;

import org.junit.jupiter.api.Test;
import step03.util.Util;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:14 오후
 */
class InputViewTest {

    @Test
    public void InputViewTest() {

        assertThat(Util.howManyCars).isEqualTo("자동차 대수는 몇 대 인가요?");
        assertThat(Util.howMuchTry).isEqualTo("시도할 회수는 몇 회 인가요?");

    }
}