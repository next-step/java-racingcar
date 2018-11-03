package racing.util;

import org.junit.Ignore;
import org.junit.Test;

public class DefaultRandomNumberProviderTest {

    // 난수가 정상 생성되는지 확인한다.
    @Test
    @Ignore
    public void getRandomNumber() {
        DefaultRandomNumberProvider provider = new DefaultRandomNumberProvider();
        System.out.println(provider.getRandomNumber());
        System.out.println(provider.getRandomNumber());
        System.out.println(provider.getRandomNumber());
        System.out.println(provider.getRandomNumber());
        System.out.println(provider.getRandomNumber());
        System.out.println(provider.getRandomNumber());
    }
}