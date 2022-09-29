package racingcar.step3_4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NamesTest {

    @DisplayName("자동차 이름을 쉼표 기준으로 구분")
    @Test
    void splitNamesWithCommaSeparatorTest() {
        String names = "pobi,crong,honux";

        String[] result = names.split(",");

        assertThat(result).containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("자동차 이름을 배열에서 Name 리스트로 변환 생성")
    @ParameterizedTest
    @CsvSource(value = {"0:pobi", "1:crong", "2:honux"}, delimiter = ':')
    void toNameListTest(int index, String name) {
        String[] names = new String[]{"pobi", "crong", "honux"};

        Names result = Names.of(names);

        assertThat(result.getNames()).contains(new Name("pobi"), new Name("crong"), new Name("honux"));
    }

    @DisplayName("입력한 자동차 이름 개수 반환")
    @Test
    void countTest() {
        String[] names = new String[]{"pobi", "crong", "honux"};

        Names result = Names.of(names);

        assertThat(result.getCount()).isEqualTo(3);
    }
}
