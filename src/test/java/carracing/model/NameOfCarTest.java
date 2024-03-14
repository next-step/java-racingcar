package carracing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NameOfCarTest {
    @Nested
    @DisplayName("NameOfCar 인스턴스 생성 테스트")
    class InstanceCreationTest {
        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {"hys12345", "!@#$%^&*", "밥은 묵고 다니나"})
        @DisplayName("5글자를 초과하는 이름으로 인스턴스를 생성하는 경우 IllegalArgumentException을 발생시킨다.")
        void testFailCase(String name) {
            assertThatThrownBy(() -> NameOfCar.newName(name))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"ysh17", "12345", "티모 대위", "#!@$", "MA!"})
        @DisplayName("5글자 이내의 이름으로 인스턴스를 생성하는 경우 정상적으로 NameOfCar의 인스턴스를 생성한다.")
        void testSuccessCase(String name) {
            assertThatObject(NameOfCar.newName(name)).isExactlyInstanceOf(NameOfCar.class);
        }
    }
}