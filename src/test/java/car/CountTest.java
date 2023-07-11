package car;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.*;

import car.domain.model.Count;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountTest {

    @DisplayName("Count 객체 생성 테스트")
    @Test
    void create() {
        Assertions.assertDoesNotThrow(() -> new Count(3));
    }

    @DisplayName("다른 객체인지 확인")
    @Test
    void isNotSameObject() {
        Count expectedCount = new Count(3);
        Count actualCount = new Count(5);

        Assertions.assertNotEquals(expectedCount, actualCount);
    }

    @DisplayName("같은 객체인지 확인")
    @Test
    void isSameObject() {
        Count expectedCount = new Count(5);
        Count actualCount = new Count(5);

        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    void 시도_횟수_감소() {
        int userInputCount = 3;
        int expectedDecreaseCount = 2;

        Count count = new Count(userInputCount);
        count.decreaseTryCount();

        assertThat(count).extracting("tryCount").isEqualTo(expectedDecreaseCount);
    }

    @DisplayName("횟수 읍수 값 입력시 exception 발생")
    @Test
    void 음수_횟수() {
        int negativeCount = -1;

        assertThrows(IllegalArgumentException.class, () -> new Count(negativeCount));
    }

}
