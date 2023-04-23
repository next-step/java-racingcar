package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 1. 자동차는 이름을 가진다.
 * 2. 속도가 4이상이면 움직인다.
 * 2-1. 속도가 3이하이면 위치가 변하지 않는다.
 * 3. 이름은 5글자 초과면 예외를 발생시킨다.
 * 4. 첫번째 위치의 자동차의 속도가 4이상이여서 두번째 위치에 도착한다.
 */
public class CarTest {
    public Car pobi;
    @BeforeEach
    void init() {
        pobi = new Car("pobi");
    }

    @DisplayName("자동차는 이름을 가진다.")
    @Test
    void getName() {
        assertEquals(pobi.getName(), "pobi");
    }

    @DisplayName("속도가 4이상이면 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_over4(int number) {
        assertEquals(pobi.move(number), 1);
    }

    @DisplayName("속도가 3이하이면 위치가 변하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void move_under3(int number) {
        assertEquals(pobi.move(number), 0);
    }

    @DisplayName("이름은 5글자 초과면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefg"})
    void checkName(String 여섯글자를_넘는_이름) {
        assertThrows(IllegalArgumentException.class, () -> new Car(여섯글자를_넘는_이름));
    }

    @DisplayName("첫번째 위치의 자동차의 속도가 4이상이여서 두번째 위치에 도착한다.")
    @Test
    void move_twoStepPosition() {
        pobi.move(5);
        pobi.move(6);
        assertEquals(pobi.getPosition(), 2);
    }

}
