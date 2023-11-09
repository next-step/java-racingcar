package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름 객체를 비교 ")
    void equal_확인() {
        Name carName1 = new Name("FuBao");
        Name carName2  = new Name("FuBao");

        assertThat(carName1).isEqualTo(carName2);
    }

}
