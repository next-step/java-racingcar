package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameTest {

    @DisplayName("문자열 포장 객체 CarName 생성 확인")
    @Test
    void createCarName() throws Exception {
        //given
        String carName = "oyeon";
        CarName oyeon = new CarName(carName);

        //when
        String name = oyeon.getName();

        //then
        assertThat(name).isEqualTo(carName);
    }
}
