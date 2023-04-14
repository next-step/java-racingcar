package study.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCarEntry {

    private CarEntry carEntry;
    
    @BeforeEach
    void setUp() {
        Car car = new Car();
        carEntry = new CarEntry(car);
    }


    @Test
    @DisplayName("CarEntry 객체의 전진 조건 테스트 - 성공")
    public void test_carentry_move_condition_success() {
        int successNum = 4;
        carEntry.move(successNum);

        Integer score = carEntry.getMoveRecord().get(0);
        assertThat(score).isEqualTo(1);
    }


    @Test
    @DisplayName("CarEntry 객체의 전진 조건 테스트 - 실패")
    public void test_carentry_move_condition_fail() {
        int failNum = 3;
        carEntry.move(failNum);

        Integer score = carEntry.getMoveRecord().get(0);
        assertThat(score).isEqualTo(0);
    }

}
