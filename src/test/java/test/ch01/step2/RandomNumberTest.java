package test.ch01.step2;

import ch01.racinggame.domain.RandomNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    static final int limitMovableNumber = 4;

    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber() {
            @Override
            public boolean movable() {
                return true;
            }
        };

    }

    @Test
    void movable() {
        assertThat(randomNumber.movable()).isTrue();
    }
}