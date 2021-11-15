package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
public class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤 값이 0 이상 9 이하인지 확인")
    public void randomTest(){
        for (int i = 0; i < 100; i++) {
            int randomNumber = RandomGenerator.getRandomNumber();
            assertTrue("랜덤 값은 0에서 9 이하가 아니다", 0 <= randomNumber && randomNumber < 10);
        }
    }
}