import org.junit.jupiter.api.Test;
import racing.utils.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    void makeNumber() throws Exception {
        //given

        //when


        //then
        for (int i = 0; i < 10; i++) {
            int num = RandomNumber.makeRandomNumber();
            assertThat(num).isGreaterThanOrEqualTo(0).isLessThan(10);
        }
    }
}
