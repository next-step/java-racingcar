package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest
{

    @BeforeEach
    void setUp(){
        System.out.println("setUp");
    }

    // 요구사항 1
    @Test
    void split1(){
        System.out.println("splint1");
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2(){
        System.out.println("split2");
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void split3(){
        System.out.printlin("split3");
        String[] result = "1,2,3".split(",");
        assertThat(result).contains("5");
    }

    @Test
    void split4(){
        System.out.printlin("split3");
        String[] result = "1,2,3".split(",");
        assertThat(result).contains("3");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

}
