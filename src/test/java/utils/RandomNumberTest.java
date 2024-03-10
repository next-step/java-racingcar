package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    void 랜덤번호_생성기() {
        int count = 10000;
        for (int i = 0; i < count; i++) {
            RandomNumber.generate();
        }
    }
}