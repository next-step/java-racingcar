import mission1.step4.CarRace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CarEntryTest {

    @DisplayName("레이스 생성시 레이스 수행횟수를 1미만으로 설정")
    @Test
    public void createCarRace() {
        assertThrows(IllegalArgumentException.class, () -> CarRace.getInstance(0));
    }
}

