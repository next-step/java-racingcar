package study.step4.try3.util;

import org.junit.jupiter.api.Test;
import study.step4.try2.util.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    void 랜덤한_숫자를_0부터9사이의_값으로_생성() {
        assertThat(RandomNumber.create()).isBetween(0,9);
    }
}