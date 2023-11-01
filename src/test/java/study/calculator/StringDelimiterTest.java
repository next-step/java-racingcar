package study.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringDelimiterTest {

    private static String DEFAULT_DELIMITER = ",|:";

    @DisplayName(" 기본 구분자 \",\", \":\" 를 뺀 문자열을 반환")
    @Test
    void checkDefaultDelimiter(){
        String target = "1,2,3";
        StringDelimiter stringDelimiter = new StringDelimiter(target);
        List<String> stringList = stringDelimiter.filteredString(new Delimiter(target));
        assertThat(stringList).doesNotContain(",");
    }

    @DisplayName(" 커스텀 구분자 \":\" 을 뺀 문자열을 반환" )
    @Test
    void checkCustomDelimiter(){
        String target = "//:\n1:2:3";
        StringDelimiter stringDelimiter = new StringDelimiter(target);
        List<String> stringList = stringDelimiter.filteredString(new Delimiter(target));
        assertThat(stringList).doesNotContain(":");
    }
}
