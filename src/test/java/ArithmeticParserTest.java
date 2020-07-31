import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticParserTest {

    @Test
    void extractOperandsFromStringTest() {
        List<Integer> ints = ArithmeticParser.extractOperandsFromString("2 3 4 5");
        assertArrayEquals(ints.toArray(), new Integer[]{2, 3, 4, 5});
    }

    @Test
    void extractOperationsFromStringTest() {
        List<Operator> ops = ArithmeticParser.extractOperationsFromString("+ - / *");
        assertArrayEquals(ops.toArray(), Operator.values());
    }
}