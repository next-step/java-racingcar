import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    public void 배열_초기화() {
        StringBuilder[] array = new StringBuilder[3];
        for (int i = 0; i < 3; i++) {
            array[i] = new StringBuilder("");
        }

        assertThat(CarRace.initializeArray(3)).isEqualTo(array);
    }
}
