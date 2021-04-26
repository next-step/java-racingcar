package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StringTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);


        assertThat(numbers.size()).isEqualTo(3);

        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    boolean setTest(int num) {
        if (!numbers.contains(num)) {
            return false;
        }
        return true;
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setsTest(int num) {
        assertTrue(setTest(num));
    }


    @ParameterizedTest
    @CsvSource(value = {"1:5","2:4","3:1"},delimiter = ':')
    void setsTest2(int num, int expected) {
        if(setTest(expected)){
            assertTrue(setTest(expected));
        };
        if(!setTest(expected)){
            assertFalse(setTest(expected));
        }
    }

    @Test
    void stringTest() {

        String str = "abc";
        assertThatThrownBy(() -> {
            if(str.length()-1 < 1) {
                throw new StringIndexOutOfBoundsException("boom!");
            }
            System.out.println(str.substring(0,1));
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


    @Test
    void split() {
        String[] arr = "1,2".split(",");
//        assertEquals(5, 3 + 2);
//        assertArrayEquals(arr, arr);

        assertThat(3 + 2).isEqualTo(5);
        assertThat(arr).contains("1", "2");

        String str = "(1,2)";
//        str.substring()str.indexOf("("),1);
        System.out.println(str.replaceAll("/([1,2])/g", "2"));


    }

    @Test
    void cal(){
        String str = "2 + 3 * 4 / 2";

        String reg = "[+*/-]";
        String reg_num = "[0-9]+";

        String[] ch = str.replaceAll(" ","").split(reg_num);
        String[] arr = str.replaceAll(" ","").split(reg);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ch));

        for(int i = 1; i <= reg_num.length(); i++){

        }


    }
}
