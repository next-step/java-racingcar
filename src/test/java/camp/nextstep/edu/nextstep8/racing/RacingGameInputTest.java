package camp.nextstep.edu.nextstep8.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameInputTest {

    @DisplayName("시도할 회수 입력시 숫자가 아닌 값이 입력 됐을 경우 IllegalArgumentException 발생")
    @Test
    public void getRoundTimesTest(){
    }

    @DisplayName("경주할 자동자 이름이 쉼표 기준으로 잘 입력되는지 확인")
    @Test
    public void getCarNumbersTest() {
    }

    @DisplayName("경주할 자동자 이름이 없을 경우 IllegalArgumentException 발생")
    @Test
    public void getCarNumbersEmptyCarsTest() {
    }
}