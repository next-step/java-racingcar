package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MatchCountTest {

    private MatchCount matchCount;

    @BeforeEach
    public void beforeEach() {
        matchCount = new MatchCount(3);
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 매치 카운트 객체가 생성되는지 확인")
    @Test
    void create_match_count() {
        assertThat(matchCount).isEqualTo(new MatchCount(3));
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 레이싱 Match Count 에 0 미만의 값을 입력한 경우 IllegalArgumentException 예외가 발생하는지 확인")
    @Test
    void pass_invalid_match_count_value_illegal_argument_exception() {
        assertThatThrownBy(() -> new MatchCount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 0 미만 일 수 없습니다.");
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 매치 카운트 decrease() 시 1 감소되는지 확인")
    @Test
    void decrease() {
        assertThat(matchCount.decrease()).isEqualTo(new MatchCount(2));
    }

    @DisplayName("5단계 - 자동차 경주(리팩토링) - 입력된 매치 카운트에 따라 isZero() 결과가 올바르게 반환되는지 확인")
    @ParameterizedTest(name = "testValue : {0}, Zero 여부 : {1}")
    @CsvSource(value = {"0:true", "1:false"}, delimiter = ':')
    void is_zero(int count, boolean expected) {
        assertThat(new MatchCount(count).isZero()).isEqualTo(expected);
    }

}
