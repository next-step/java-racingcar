package step3;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class RandomSingletonTest {
    @Test
    void Given_SingletonInstance_When_Get_Two_Instance_Then_Equal_HashCode() {
        RandomSingleton instance = RandomSingleton.INSTANCE;

        Random random1 = instance.getInstance();
        Random random2 = instance.getInstance();

        assertThat(random1).isEqualTo(random2);
    }
}
