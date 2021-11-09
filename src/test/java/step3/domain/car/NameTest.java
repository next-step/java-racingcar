package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    private static final String NameTooLong = "aaaaaa";

    @DisplayName("이름의 길이가 1이상 5이하가 아니라면 Name 생성시 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] name: {0}")
    @NullAndEmptySource
    @ValueSource(strings = {NameTooLong})
    void createName(String inputName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(inputName))
                .withMessage(Name.NAME_LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("문자열로 NAME 리스트 만들기")
    @Test
    void listOfEqualsTest() {
        //given
        String name1 = "길동";
        String name2 = "미미";
        String name3 = "철수";
        String input = name1 + "," + name2 + "," + name3;

        //when
        List<Name> names = Name.listOf(input);

        //then
        List<Name> expectedNames = asList(new Name(name1), new Name(name2), new Name(name3));
        assertThat(names).isEqualTo(expectedNames);
    }

}
