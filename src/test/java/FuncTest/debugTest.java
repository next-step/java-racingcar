package FuncTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class debugTest {
    @Test
    void debug3() {
        String str = "//;\n1;2;3";
        assertThat(str.substring(str.indexOf("\n")+1)).isEqualTo("1;2;3");
    }
    @Test
    void debug2() {
        assertThat(",|:|" + ";").isEqualTo(",|:|;");
    }
    @Test
    void debug() {
        String str = "//;\n1;2;3";
        assertThat(str.substring(str.indexOf("//")+2,str.indexOf("\n"))).isEqualTo(";");
    }

}
