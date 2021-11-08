package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("Names 배열을 ,로 이어진 스트링으로 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"miz,ki,bi"})
    void toStringTest(String input) {
        List<Name> nameList = createNameList(input);
        Winners winners = Winners.create(nameList);

        assertThat(winners.toString()).isEqualTo(input);
    }

    private List<Name> createNameList(String input) {
        return Arrays.stream(input.split(",")).map(Name::new)
                .collect(Collectors.toList());
    }
}