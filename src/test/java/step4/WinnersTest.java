package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Name;
import step4.domain.Names;
import step4.service.dto.Winners;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("Names 배열을 가진다.")
    @ParameterizedTest
    @ValueSource(strings = {"miz,ki,bi"})
    void createWinnerTest(String input) {
        Names names = createNames(input);
        Winners winners = Winners.create(names);

        assertThat(winners.getWinners()).isEqualTo(names);
    }

    private Names createNames(String input) {
        List<Name> nameList = Arrays.stream(input.split(",")).map(Name::new)
                .collect(Collectors.toList());
        Names names = new Names();
        names.addNames(nameList);
        return names;
    }
}