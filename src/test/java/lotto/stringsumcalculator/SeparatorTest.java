package lotto.stringsumcalculator;

import lotto.stringsumcalculator.model.Separator;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class SeparatorTest {

    @Test
    @DisplayName("구분자를 잘 생성하는가")
    public void createSeparator(){
        Separator separator = new Separator(";");
        assertEquals(separator.getString(),";");
    }
}
