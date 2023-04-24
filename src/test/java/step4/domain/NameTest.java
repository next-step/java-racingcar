package step4.domain;

import org.junit.jupiter.api.Test;
import step4.exception.NameExceedException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    void name의_길이가_5를_초과할경우_예외를_던진다() {
        assertThrows(
                NameExceedException.class,
                () -> Name.from("abcdef")
        );
    }

    @Test
    void List의_Name을_출력형식에_맞게_파싱한다() {
        final List<Name> names = List.of(Name.from("pobi"), Name.from("crong"));
        final String expected = "pobi,crong";

        final String actual = Name.parseWinnerNames(names);

        assertThat(actual).isEqualTo(expected);
    }

}