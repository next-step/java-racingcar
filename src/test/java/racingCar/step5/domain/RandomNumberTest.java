package racingCar.step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {
    @DisplayName("9이하의 랜덤한 숫자 조회가 가능하다")
    @Test
    void generateRandomNumber(){
        RandomNumber randomNumber = new RandomNumber();

        assertThat(randomNumber.generate()).isBetween(0,9);
    }

    @DisplayName("고정된 숫자 조회가 가능하다")
    @Test
    void fixedRandomNumber(){
        RandomNumber randomNumber = new RandomNumber(3);

        assertThat(randomNumber.generate()).isEqualTo(3);
    }
}