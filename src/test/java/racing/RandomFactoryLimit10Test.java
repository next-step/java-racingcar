package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;


class RandomFactoryLimit10Test {

    @RepeatedTest(5)
    void random값은_0과10사이다(){
        RandomFactory factory = new RandomFactoryLimit10();
        Assertions.assertThat(factory.getNextInt()).isBetween(0,10);
    }
}