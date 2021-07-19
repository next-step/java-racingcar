import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Step1 {
    @Test
    void stringTest(){
        String[] result  = "1,2".split(",");
        Assertions.assertThat(result).containsExactly("1","2");
    }
}
