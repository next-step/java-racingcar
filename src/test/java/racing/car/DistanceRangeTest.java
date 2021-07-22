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
            "4,MOVEMENT",
            "5,MOVEMENT",
            "6,MOVEMENT",
            "9,MOVEMENT",
            "10,LIMIT_MOVEMENT",
            "15,LIMIT_MOVEMENT"
    })
    @ParameterizedTest
    public void ofTest(int distance, String objName) {
        assertThat(
                DistanceRange.of(distance).name()
        ).isEqualTo(objName);
    }
}