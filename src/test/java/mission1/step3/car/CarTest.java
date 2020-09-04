package mission1.step3.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    //carRace에서 이미 유효성 검증을 하는데 해당 테스트가 의미가 있는지 궁금합니다.
//    @DisplayName("레이스에 참여할 자동차 리스트 생성시 인자값이 1 미만 일 경우")
//    @ParameterizedTest
//    @ValueSource(ints = {-1, 0})
//    public void insertInappositeValue(int input) {
//        assertThrows(IllegalArgumentException.class, () -> CarFactory.createCarList(input));
//    }

    @DisplayName("레이스에 참여할 자동차 리스트 생성")
    @ParameterizedTest
    @CsvSource({"4, 4", "3, 3"})
    public void insertInappositeValue(int input, int result) {
        assertEquals(CarFactory.createCarList(input).size(), result);
    }
}
