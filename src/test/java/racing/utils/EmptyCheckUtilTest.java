package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmptyCheckUtilTest {

    @DisplayName("null String 객체 테스")
    @Test
    void emptyCheckUtilsTestByNullString() {
        String argument = null;
        assertThatThrownBy(() -> EmptyCheckUtil.emptyCheck(argument))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("비어있는 String 객체 테스트")
    @Test
    void emptyCheckUtilsTestByEmptyString() {
        assertThatThrownBy(() -> EmptyCheckUtil.emptyCheck(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("null Object 객체 테스트")
    @Test
    void emptyCheckUtilsTestByNullObject() {
        Object argument = null;
        assertThatThrownBy(() -> EmptyCheckUtil.emptyCheck(argument))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("null List 객체 테스트")
    @Test
    void emptyCheckUtilsTestByNullList() {
        List argument = null;
        assertThatThrownBy(() -> EmptyCheckUtil.emptyCheck(argument))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("비어있는 List 객체 테스트")
    @Test
    void emptyCheckUtilsTestByEmptyList() {
        List argument = new ArrayList();
        assertThatThrownBy(() -> EmptyCheckUtil.emptyCheck(argument))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("null Array 객체 테스트")
    @Test
    void emptyCheckUtilsTestByNullArray() {
        Object[] argument = null;
        assertThatThrownBy(() -> EmptyCheckUtil.emptyCheck(argument))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("비어있는 Array 객체 테스트")
    @Test
    void emptyCheckUtilsTestByEmptyArray() {
        Object[] argument = new Object[]{};
        assertThatThrownBy(() -> EmptyCheckUtil.emptyCheck(argument))
                .isInstanceOf(IllegalArgumentException.class);
    }
}