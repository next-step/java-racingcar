package study;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {
    @Test
    void nextInt() {
        Random random = new Random();
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
    }
}
