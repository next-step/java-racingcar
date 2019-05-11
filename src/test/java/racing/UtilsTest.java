package racing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.Utils.splitCarNames;

public class UtilsTest {
    @Test
    public void 랜덤_숫자_생성() {
        //when
        int random = Utils.generateRandomNum();

        //then
        assertThat(random).isBetween(0, 9);
    }

    @Test
    public void 자동차_이름을_입력한다() {
        //given
        //when
        String[] names = splitCarNames("m1, m2");

        //then
        assertThat(names).hasSize(2);
    }
}