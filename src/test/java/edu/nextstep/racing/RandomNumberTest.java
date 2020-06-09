package edu.nextstep.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
    }

    @DisplayName("난수생성 테스트")
    @Test
    void generatorTest() {
        assertThat(randomNumber.generator())
                .isBetween(0, 9);
    }
}
