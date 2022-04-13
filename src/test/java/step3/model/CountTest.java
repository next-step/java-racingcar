package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Count 테스트")
class CountTest {

    @Test
    void 정수를_입력받아서_Wrapping하는_Count_객체를_생성() {
        assertThat(new Count(1).getCount()).isEqualTo(1);
    }

    @Test
    void 음수를_입력받아서_Count_객체를_생성하는_경우_예외() {
        assertThatThrownBy(() -> new Count(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Count_객체_간의_덧셈_연산이_가능하다() {
        Count one = new Count(1);
        Count two = new Count(2);

        Count result = one.add(two);

        assertThat(result.getCount()).isEqualTo(3);
    }
}