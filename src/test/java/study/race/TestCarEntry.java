package study.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCarEntry {

    private CarEntry carEntry;
    
    @BeforeEach
    void setUp() {
        Car car = new Car();
        carEntry = new CarEntry(car);
    }

    @ParameterizedTest
    @CsvSource({"4, 1", "2, 0"})
    @DisplayName("CarEntry 객체의 전진 조건 테스트")
    public void test_carentry_move_for_condition(int conditionNum, int moveNum) {
        carEntry.move(conditionNum);

        Integer score = carEntry.getMoveRecord().get(0);
        assertThat(score).isEqualTo(moveNum);
    }

}
