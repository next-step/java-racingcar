import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.utils.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    void makeNumber() throws Exception {
        //given
        RandomNumber randomNumber = new RandomNumber();

        //when


        //then
        for (int i = 0; i < 10; i++) {
            int num = randomNumber.makeRandomNumber();
            assertThat(num >= 0 & num < 10).isTrue();
        }
    }
}
