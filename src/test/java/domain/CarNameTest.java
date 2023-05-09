package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {
    String defaultName;
    CarName defaultCarName;
    String overMaxSizeName;

    @BeforeEach
    void setUp() {
        defaultName = "pobi";
        overMaxSizeName = "haha this is longer name";
        defaultCarName = CarName.create(defaultName);
    }

    @Test
    @DisplayName("CarName 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> CarName.create(defaultName));
    }

    @Test
    @DisplayName("최대길이가 넘어가는 이름으로 CarName 생성 시 실패")
    void createWithOverMaxSize() {
        Assertions.assertThatThrownBy(() -> CarName.create(overMaxSizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("CarName can not over length 5");
    }

    @Test
    @DisplayName("생성자 이름 가져오기 테스트")
    void name() {
        assertEquals(defaultName, defaultCarName.name());
    }
}
