package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.util.Utils;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    @DisplayName("0~10까지 랜덤 숫자 가져오기 테스트")
    void createRandomNumberTest(){
        int randomNumber = Utils.createRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

}
