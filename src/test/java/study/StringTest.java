package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @BeforeEach // 각 @Test 메서드가 실행되기 전에 실행된다.
    void setUp(){
        System.out.println("setUp");
    }

    @AfterEach // 각 @Test 메서드가 실행된 후에 실행된다.
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test // 각 @Test 메소드의 실행 순서는 랜덤이다. 즉, 각 테스트는 독립적이다.
    void split1() {
        System.out.println("split1");
        String[] result = "1,2".split(",");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2() {
        System.out.println("split2");
        // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다
        String result = "(1,2)";
        assertThat(result.substring(1,4)).isEqualTo("1,2");
    }

    @Test
    void split3() {
        System.out.println("split3");
        //"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        //String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.

        /*assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    // ...
                }).hasMessageMatching("Index: \\d+, Size: \\d+");*/


//        String result = "abc";
//
//        assertThat(result.charAt(0)).isEqualTo("a");
//        assertThat(result.charAt(1)).isEqualTo("b");
//        assertThat(result.charAt(2)).isEqualTo("c");
//
//        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
//                .isThrownBy(()-> {
//                    result.charAt(3);
//        }).hasMessageMatching("Index: \\d+, Size: \\d+");
    }




    @Test
    void contains() {
        String result = "aaa";
        assertThat(result.charAt(0)).isEqualTo("a");
        assertThat(result.charAt(1)).isEqualTo("a");
        assertThat(result.charAt(2)).isEqualTo("a");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @Test
    void contains(int num) {
        String result = "aaa";
        assertThat(result.charAt(num)).isEqualTo("a");
    }



}