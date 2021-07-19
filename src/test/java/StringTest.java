import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    static String[] splitedStrings;

    @BeforeEach
    public void setSplitStrings(){
        splitedStrings = "1,2".split(",");
    }

    // contains는 배열시 순서상관 없음
    @Test
    public void 요구사항1_contains1to2(){
        assertThat(splitedStrings).contains("1","2");
    }
    @Test
    public void 요구사항1_contains2to1(){
        assertThat(splitedStrings).contains("2","1");
    }
    
    //containsExactly의 경우 순서 상관 있음
    @Test
    public void 요구사항1_containsExactly1to2(){
        assertThat(splitedStrings).containsExactly("1","2");
    }
    @Test
    public void 요구사항1_containsExactly2to1(){
        assertThat(splitedStrings).containsExactly("2","1");
    }

    @Test
    public void 요구사항1_containsOnly1(){
        splitedStrings = "1".split(",");
        assertThat(splitedStrings).containsExactly("1");
    }

    @Test
    public void 요구사항2(){
        String subString = "(1,2)".substring(1,4);
        assertThat(subString).isEqualTo("1,2");
    }
}
