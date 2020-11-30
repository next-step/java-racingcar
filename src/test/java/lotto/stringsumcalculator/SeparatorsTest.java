package lotto.stringsumcalculator;

import lotto.stringsumcalculator.model.Separators;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class SeparatorsTest {

    @Test
    @DisplayName("구분자 생성이 제대로 되는가")
    public void createSeparator(){
        Separators separators = new Separators("//;\\n1;2;3");
        assertEquals(separators.getSeparator(0).getString(),",");
        assertEquals(separators.getSeparator(1).getString(),":");
        assertEquals(separators.getSeparator(2).getString(),";");
    }

    @Test
    @DisplayName("커스텀 구분자를 여러 개 추가할 수도 있는가")
    public void addManyCustomSeparator(){
        Separators separators = new Separators("//;\\n//[\\n//]\\n1;2;3");
        assertEquals(separators.getSeparator(0).getString(),",");
        assertEquals(separators.getSeparator(1).getString(),":");
        assertEquals(separators.getSeparator(2).getString(),";");
        assertEquals(separators.getSeparator(3).getString(),"[");
        assertEquals(separators.getSeparator(4).getString(),"]");
    }

}
