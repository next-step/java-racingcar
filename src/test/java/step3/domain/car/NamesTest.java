package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @DisplayName("문자열로 NAME 리스트 만들기")
    @Test
    void listOfEqualsTest() {
        //given
        String name1 = "길동";
        String name2 = "미미";
        String name3 = "철수";
        String input = name1 + "," + name2 + "," + name3;

        //when
        Names names = Names.from(input);

        //then
        Names expectedNames = new Names(asList(new Name(name1), new Name(name2), new Name(name3)));
        assertThat(names).isEqualTo(expectedNames);
    }

}
