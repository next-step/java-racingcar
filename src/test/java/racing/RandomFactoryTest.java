package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;


class RandomFactoryTest {

    @RepeatedTest(5)
    @DisplayName("random 값은 0과 10 사이있다")
    void randomValueBetween0to10(){
        RandomFactory factory = new RandomFactory();
        Assertions.assertThat(factory.getNextInt()).isBetween(0,10);
    }
}