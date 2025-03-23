package step5.racingcar3.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameListTest {

    @Test
    @DisplayName("CarNameList 일급컬렉션 생성 테스트")
    void givenCarNameList_whenCreateCarNameList_thenSuccess() {
        // given
        CarName carName1 = new CarName("a");
        CarName carName2 = new CarName("b");
        CarName carName3 = new CarName("c");
        CarName carName4 = new CarName("d");
        CarName carName5 = new CarName("e");

        // when
        // then
        assertDoesNotThrow(() -> new CarNameList(List.of(carName1, carName2, carName3, carName4, carName5)));
    }

}
