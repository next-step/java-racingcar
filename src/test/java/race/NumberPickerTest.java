package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.domain.NumberPicker;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberPickerTest {

    @Test
    @DisplayName("Random 값은 항상 1~9사이를 return한다.")
    public void testGetRandomInt_WithFakeRandom() {
        FakeRandom fakeRandom = new FakeRandom(5);
        NumberPicker numberPicker = new NumberPicker(fakeRandom);

        int result = numberPicker.generateRandomNumber(10);

        assertThat(result).isEqualTo(5);
    }
}


