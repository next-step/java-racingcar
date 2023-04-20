package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.calculator.SeparatorList;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorListTest {
    SeparatorList separatorList;
    @BeforeEach
    public void setUp() {
        this.separatorList = new SeparatorList();
    }

    @Test
    @DisplayName("기본 구분자 정규식 조회 테스트")
    public void makeDefaultSeparatorRegexTest() {
        assertThat(this.separatorList.makeSeparatorRegex()).isEqualTo(":|,");
    }
    @Test
    @DisplayName("구분자 추가 테스트 : 추가되는 구분자 ;")
    public void addSeparatorText() {
        this.separatorList.add(";");
        assertThat(this.separatorList.makeSeparatorRegex()).isEqualTo(":|;|,");
    }
}
