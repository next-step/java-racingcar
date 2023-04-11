package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    public void 문자_입력_받기() {
        // Given
        String testInput = "3\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // When
        RacingCar.inputView();

        // Then
    }

    @Test
    public void 랜덤하게_전진() {
        // Given
        int iterations = 100;

        for(int i = 0; i < iterations; i ++) {
            // When
            int randomNumber = RacingCar.getRandomNumber();
            int proceed = RacingCar.proceed(randomNumber);

            // Then
            if(randomNumber > RacingCar.PROCEEDING_NUM)
                assertThat(proceed).isOne();

            if(randomNumber < RacingCar.PROCEEDING_NUM)
                assertThat(proceed).isZero();
        }
    }
}
