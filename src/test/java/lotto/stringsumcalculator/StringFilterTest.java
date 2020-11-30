package lotto.stringsumcalculator;

import lotto.stringsumcalculator.model.StringFilter;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class StringFilterTest {

    @Test
    @DisplayName("특수문자로 split이 잘 되게 문자열을 변경해주는가")
    public void fintering(){
        String string = "1;2+3?4{5}6";
        assertEquals(string.split(StringFilter.filtering("+"))[0],"1;2");
        assertEquals(string.split(StringFilter.filtering("+"))[1],"3?4{5}6");

        assertEquals(string.split(StringFilter.filtering("?"))[0],"1;2+3");
        assertEquals(string.split(StringFilter.filtering("?"))[1],"4{5}6");

        assertEquals(string.split(StringFilter.filtering("{"))[0],"1;2+3?4");
        assertEquals(string.split(StringFilter.filtering("{"))[1],"5}6");
    }
}
