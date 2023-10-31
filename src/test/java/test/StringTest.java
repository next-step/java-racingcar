package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void StringTest1(){

        //"1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        String str = "1,2";

        List<String> list = List.of(str.split(","));

        System.out.println(list);

        Assertions.assertThat(list).contains("1", "2");
        Assertions.assertThat(list).containsExactly("1", "2");

        //"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        String str2 = "1";
        List<String> list2 = List.of(str2.split(","));

        Assertions.assertThat(list2).contains("1");
        Assertions.assertThat(list2).containsExactly("1");
    }

    @Test
    public void StringTest2(){
        //"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
        String str = "(1,2)";
        String subStr = str.substring(1,4);
        System.out.println(subStr);
    }

    @Test
    @DisplayName("charAt() 테스트")
    public void StringTest3(){
        // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        // JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
        String str = "abc";

        int j = 2;
        assertThatThrownBy(() -> {
            str.charAt(j);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: %d, Size: %d", j, j);

    }
}
