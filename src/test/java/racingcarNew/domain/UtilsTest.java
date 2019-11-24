package racingcarNew.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {
    @Test
    void 랜덤값이_10_보다_작은_숫자가_나오는지_확인() {
        Utils utils = new Utils();
        assertThat(Utils.getRandomNo()).isBetween(0, 10);
    }
}