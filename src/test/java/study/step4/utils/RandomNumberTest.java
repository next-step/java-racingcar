package study.step4.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {
    @Test
    void 랜덤한_숫자를_0에서_9사이로_출력() {
        assertThat(RandomNumber.create()).isBetween(0,9);
    }
}