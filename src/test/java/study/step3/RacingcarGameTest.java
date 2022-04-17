package study.step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarGameTest {

    private RandomNumber randomNumber = new RandomNumber();

    @Test
    @DisplayName("0부터 9까지의 랜덤한 숫자를 만든다.")
    void 영부터_구까지의_랜덤한_숫자생성() {
        assertThat(randomNumber.generateRandomNumber()).isBetween(0,9);
    }
}
