package study;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {

    @Test
    public void 랜덤값_0에서9사이_가져오기() {
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }
}
