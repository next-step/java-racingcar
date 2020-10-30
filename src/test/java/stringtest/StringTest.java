package stringtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    
    @Test
    void splitTest(){
        String[] strArray = "1,2".split(",");
        assertThat(strArray).contains("1", "2");
        assertThat(strArray).contains("1", strArray[0]);
        assertThat(strArray).containsExactly("1", "2");

        String[] strArray2 = strArray[0].split(",");
        assertThat(strArray2).contains("1", strArray2[0]);
        
    }
}