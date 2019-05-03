package racing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {
    @Test
    public void 랜덤_숫자_생성() {
        //when
        int random = Utils.generateRandomNum();

        //then
        assertThat(random).isBetween(0, 9);
    }
}