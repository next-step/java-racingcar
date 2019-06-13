package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @BeforeEach // 테스트 이전에 실행
    void setUp() {
        System.out.println("setUp====");
    }

    //@Test
    void split() {
        String[] result = "1,2".split(",");
        //System.out.println(result[0]);
        //System.out.println(result[1]);
        System.out.println("split====");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
        assertThat(result).containsExactly("1","2");
    }

    //@Test
    void split1() {
        System.out.println("split1====");
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
        assertThat(result).contains("1","2");
    }

    //@Test
    void split2() {
        System.out.println("split2====");
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");

    }

    void split3() {
        //String[] result = "(1,2)".substring()
    }

    @AfterEach // 각 테스트가 독립적으로 실행되기 위해 초기화 작업을 매번 함
    void teaarDown() {
        System.out.println("tear Down");
    }

}
