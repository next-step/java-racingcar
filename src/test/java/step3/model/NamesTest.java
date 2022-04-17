package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Names 테스트")
class NamesTest {

    @Test
    void _문자열을_입력받아_컴마로_구분하여_Name객체_리스트_생성() {
        String input = "1,2";
        List<Name> expect = Arrays.asList(new Name("1"), new Name("2"));

        Names names = new Names(input);

        assertThat(names.getEachNames()).usingRecursiveComparison().isEqualTo(expect);
    }
}
