package racingCar;

import exception.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberVerifierTest {

    @Test
    public void testVerify_WithPositiveNumber() {
        NumberVerifier verifier = new NumberVerifier();
        verifier.verify(5);
    }

    @Test
    public void testVerify_WithZero_ShouldThrowException() {
        NumberVerifier verifier = new NumberVerifier();
        assertThrows(NegativeNumberException.class, () -> verifier.verify(0));
    }

    @Test
    public void testVerify_WithNegativeNumber_ShouldThrowException() {
        NumberVerifier verifier = new NumberVerifier();
        assertThrows(NegativeNumberException.class, () -> verifier.verify(-1));
    }
}

