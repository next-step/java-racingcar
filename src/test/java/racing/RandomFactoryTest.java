package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;


class RandomFactoryTest {

    @RepeatedTest(5)
    void random값은_0과10사이다(){
        RandomFactory factory = new RandomFactory();
        Assertions.assertThat(factory.getNextInt()).isBetween(0,10);
    }
}