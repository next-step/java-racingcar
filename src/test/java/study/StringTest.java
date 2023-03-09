package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringTest {

    private Set<Integer> numbers;

//    @BeforeEach

    @Test
    void split() {
        String[] split = "1,2".split(",");
        System.out.println(Arrays.toString(split));
        assertThat(split).containsExactly("1","2","3");
    }

    @Test
    void split2() {
        String[] split2 = "1".split(",");
        System.out.println(Arrays.toString(split2));
        assertThat(split2).containsExactly("1");
    }

    @Test
    void indexOf() {
        String orginal = "abc";
        System.out.println(orginal.indexOf("c"));
//        assertThat(split2).containsExactly("1");
    }
//
//    @Test
//    void name() {
//        final String actual = "(1,2)".substring(1,4);
//        assertThat(actual).isEqualTo("1,2");
//    }
//
//    @DisplayName("특정위치의 문자를 가져올 때 벗어나면 예외가 발생한다")
//    @Test
//    void charAt21() {
//        final char actual = "abc".charAt(4);
//        assertThat(actual).isEqualTo('c');
//    }

//    @DisplayName("특정위치의 문자를 가져올 때 벗어나면 예외가 발생한다")
//    @Test
//    void charAt2() {
//        final char actual = "abc".charAt(4);
//        assertThat(actual).isEqualTo('c');
//    }


    @Test
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
//        final int actual =  numbers.size();
//        assertThat(actual).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(final int number) {
        assertThat(numbers.contains(number)).isTrue();
    }


}
