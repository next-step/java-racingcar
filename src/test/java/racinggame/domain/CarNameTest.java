package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @DisplayName("자동차 이름의 길이는 5자를 초과 할 수 없음")
    @Test
    void 자동차_이름_길이_5자_초과_불가_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Car("제네시스SUV"));
    }

    @DisplayName("자동차 이름은 빈문자열 생성 불가")
    @Test
    void 자동차_이름_빈문자열_생성_불가_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }
}
