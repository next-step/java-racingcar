package racing;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class InputViewTest {

    @Test
    public void inputCarNameTest_Blank() {
        String input = " \n";
        InputStream in = new ByteArrayInputStream(input.trim().getBytes());
        System.setIn(in);
        assertEquals(null, InputView.inputCarName());
    }

    @Test
    public void inputCarNameTest_Null() {
        String input = "shin";
        InputStream in = new ByteArrayInputStream(input.trim().getBytes());
        System.setIn(in);
        assertEquals("shin", InputView.inputCarName());
    }
}