import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.utils.RandomNumber;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {
    @Test
    public void makeNumber() {
        //given
        RandomNumber randomNumber = new RandomNumber();
        //when
        //then
        int number1 = randomNumber.makeOneRandomNumber();

        assertThat(number1).isBetween(0, 9);
    }
}
