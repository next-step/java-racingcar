package study.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    @DisplayName("name 길이가 허용 범위가 아닌 경우 RuntimeException 예외 발생")
    void name_길이가_허용_범위가_아닌_경우_RuntimeException_발생() {
        String input = "프리티푸바오";
        assertThrows(RuntimeException.class, () -> new Name(input));
    }
}