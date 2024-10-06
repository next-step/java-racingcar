package race;

import org.junit.jupiter.api.Test;
import race.domain.NumberPicker;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberPickerTest {

    @Test
    public void 랜덤값은_항상_1에서9를_반환한다() {
        FakeRandom fakeRandom = new FakeRandom(5);
        NumberPicker numberPicker = new NumberPicker(fakeRandom);

        int result = numberPicker.generateRandomNumber(10);

        assertThat(result).isEqualTo(5);
    }
}


