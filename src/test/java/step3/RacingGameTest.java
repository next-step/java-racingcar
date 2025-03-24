package step3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    private RacingGame racingGame;

    @Test
    void testNoMovement() {
        // 랜덤값 4 미만일 시(e.g. 3) Car의 position은 변하지 않아야 함.
        Random mockRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        Car car = new Car();

        int initialPosition = car.getPosition();
        car.move();

        assertEquals(initialPosition, car.getPosition());
    }

    @Test
    void testMoveForward() {
        // 랜덤값 4 이상일 시(e.g. 5) Car의 position은 1씩 증가해야함.
        Random mockRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };
        Car car = new Car();

        int initialPosition = car.getPosition();
        car.move();

        assertEquals(initialPosition+1, car.getPosition());
    }
}
