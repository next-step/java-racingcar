import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.utils.RandomNumber;

public class RandomNumberTest {
    @Test
    public void makeNumber() {
        //given
        RandomNumber randomNumber = new RandomNumber();
        //when
        //then
        int number1 = randomNumber.makeOneRandomNumber();

        Assertions.assertThat(number1).isBetween(1, 9);
    }
}
