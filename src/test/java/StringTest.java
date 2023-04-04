
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest{

    @Test
    void StringTestRequirement01(){

        String[] actual01 = "1,2".split(",");
        Assertions.assertThat(actual01).containsExactly("1","2"); //배열의 순서와 크기가 동일한지

        String[] actual02 = "1,2".split(",");
        Assertions.assertThat(actual02).contains("1"); //포함 여부

    }

    @Test
    void StringTestRequirement02(){

        String actual = "(1,2)";
        actual = actual.substring(1,actual.length()-1);

        Assertions.assertThat(actual).contains("1,2");

    }

    @Test
    @DisplayName("charAt()메쏘드를 이용해 특정 위치 문자열 조회(IndexOut 예외처리)")
    void StringTestRequirement03(){

        char actual01 = "abc".charAt(0);
        Assertions.assertThat(actual01).isEqualTo('a');

        Assertions.assertThatThrownBy(()->{

            char actual02 = "abc".charAt(3);

        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, Size:2");


    }
}