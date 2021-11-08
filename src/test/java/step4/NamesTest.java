package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    private Names names;

    @BeforeEach
    void setUp() {
        names = new Names();
    }

    @DisplayName(",로 나뉘어진 문자열로 Name을 한번에 추가할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"miz,marty,kk", "abc,cde,123"})
    void addNamesTest(String input) {
        String[] split = input.split(",");
        List<Name> collect = Arrays.stream(split).map(Name::new).collect(Collectors.toList());

        names.addNames(input);

        assertThat(names.getNames()).containsAll(collect);
    }

}