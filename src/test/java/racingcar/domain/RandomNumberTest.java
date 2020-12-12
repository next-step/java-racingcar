package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    @DisplayName("랜덤번호 0~9 범위의 생성 ")
    void createRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();
        int no = randomNumber.condition();
        System.out.println(no);
        assertThat(no).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }


}
