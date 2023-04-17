package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameManagementTest {

    @Nested
    @DisplayName("이름 분리 관련 테스트")
    class split{
        @Test
        @DisplayName("이름 분리 통과")
        void split () {
            CarNameManagement management = new CarNameManagement("pobi,crong,honux");

            assertThat(management.getNames()).containsExactly("pobi", "crong", "honux");
        }

        @Test
        @DisplayName("참가한 자동차가 없을 경우")
        void splitExceptionNoPlayer() {
            assertThatThrownBy(()-> { CarNameManagement management = new CarNameManagement(""); })
                    .isInstanceOf(RuntimeException.class).hasMessageContaining("player zero");
        }

    }

    @Nested
    @DisplayName("이름 검증")
    class validate {
        @Test
        @DisplayName("자동차 이름이 5글자 초과 시")
        void validateWithNameLengthOver5() {
            assertThatThrownBy(()-> { CarNameManagement management = new CarNameManagement("pobi,crongo"); })
                    .isInstanceOf(RuntimeException.class).hasMessageContaining("over 5 length");
        }
    }
}
