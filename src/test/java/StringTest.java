import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @BeforeEach
    void setup(){
        System.out.println("setup");
    }

    @Test
    void split(){
        System.out.println("split");
        String[] result ="1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring(){
        System.out.println("substring");
        String result ="(1,2)".substring(1,4);
        assertThat(result).contains("1,2");

    }

//    @ParameterizedTest
//    @ValueSource(ints ={1,2,3})
//    void
}
