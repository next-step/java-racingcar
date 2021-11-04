package step2;

import org.junit.jupiter.api.Test;
import step2.model.MyNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyNumberTest {

    @Test
    void equal() {
        MyNumber mynumber = new MyNumber("1");
        assertTrue(mynumber.equals(new MyNumber(1)));
    }

    @Test
    void hasCode() {
        MyNumber myNumber = new MyNumber("1");
        MyNumber myNumber2 = new MyNumber("1");
        assertEquals(myNumber.hashCode(),myNumber2.hashCode());

    }

}
