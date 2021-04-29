import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.utils.RandomNumber;

public class RandomNumberTest {
    @Test
    public void makeNumber() throws Exception {
        //given
        RandomNumber randomNumber = new RandomNumber();

        //when


        //then
        for(int i = 0; i<10; i++) {
            int num = randomNumber.makeRandomNumber();
            Assertions.assertThat(num >= 0 & num < 10).isTrue();
        }
    }
}
