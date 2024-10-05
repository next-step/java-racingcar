package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    void 생성() {
        RandomNumber randomNumber = new RandomNumber(4);

        assertThat(randomNumber).isEqualTo(new RandomNumber(4));
    }
}
