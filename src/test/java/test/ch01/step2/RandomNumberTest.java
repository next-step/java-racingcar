package test.ch01.step2;

import ch01.racinggame.Domain.RandomNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class RandomNumberTest {

    static final int limitMovableNumber = 4;
    private int number = 0;
    RandomNumber randomNumber;
    @BeforeEach
    void setUp(){
        number = 0;
        randomNumber = new RandomNumber();

    }
    @Test
    void movable() {
        boolean isMoveable = randomNumber.movable();
        assertThat(isMoveable).isTrue();
    }
}