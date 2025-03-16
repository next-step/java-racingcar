package racingCar;

import exception.NegativeNumberException;

public class NumberVerifier {
    void verify(int num) {
        if (num <= 0) {
            throw new NegativeNumberException();
        }
    }
}
