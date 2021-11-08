package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyNumberTest {

    @Test
    void myNumber() {
        MyNumber myNumber = new MyNumber("1");
        assertEquals(myNumber, new MyNumber("1"));
    }

    @Test
    void plusSuccess() {
        MyNumber myNumber = new MyNumber("1");
        assertEquals(myNumber.plus(new MyNumber("2")), new MyNumber("3"));
    }

    @Test
    void minusSuccess() {
        MyNumber myNumber = new MyNumber("1");
        assertEquals(myNumber.minus(new MyNumber("2")), new MyNumber("-1"));
    }

    @Test
    void multiplySuccess() {
        MyNumber myNumber = new MyNumber("6");
        assertEquals(myNumber.multiply(new MyNumber("2")), new MyNumber("12"));
    }

    @Test
    void divideSuccess() {
        MyNumber myNumber = new MyNumber("6");
        assertEquals(myNumber.divide(new MyNumber("2")), new MyNumber("3"));
    }
}
