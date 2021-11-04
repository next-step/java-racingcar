package step2;

import org.junit.jupiter.api.Test;
import step2.model.MyNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyNumberTest {
    @Test
    void create() {
        MyNumber mynumber = new MyNumber("1");
        assertTrue(mynumber.equals(new MyNumber(1)));
    }

}
