package Practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringText1Test {

    @Test
    void confirmString() {
        StringText1 stringText1 = new StringText1();

        Assertions.assertThat(stringText1.changeText1).isEqualTo("1,2");
        Assertions.assertThat(stringText1.changeText2).isEqualTo("1,2");
    }
}