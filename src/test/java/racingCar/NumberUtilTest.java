package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {

    @Test
    @DisplayName("Random 값은 항상 1~9사이를 return한다.")
    public void testGetRandomInt_WithFakeRandom() {
        FakeRandom fakeRandom = new FakeRandom(5);
        NumberUtil numberUtil = new NumberUtil(fakeRandom);

        int result = numberUtil.getRandomInt();

        assertThat(result).isEqualTo(5);
    }
}


