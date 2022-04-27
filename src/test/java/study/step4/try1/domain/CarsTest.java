package study.step4.try1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차 객체를 생성")
    void 자동차_객체를_생성() {
        assertThat(new Cars("pobi, crong, honux").getCars().size()).isEqualTo(3);
    }
}
