package racing.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceRangeTest {
    @CsvSource({
            "-1,BACK_MOVEMENT",
            "0,NOT_MOVEMENT",
            "1,NOT_MOVEMENT",
            "2,NOT_MOVEMENT",
            "3,NOT_MOVEMENT",
            "4,MIN_MOVEMENT",
            "5,MIN_MOVEMENT",
            "6,MIN_MOVEMENT",
            "10,MAX_MOVEMENT",
            "15,MAX_MOVEMENT"
    })
    @ParameterizedTest
    public void ofTest(int distance, String objName) {
        assertThat(
                DistanceRange.of(distance).name()
        ).isEqualTo(objName);
    }
}