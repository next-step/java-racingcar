package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class VictoryTest {
    List<Car> carList = new ArrayList<Car>();
    int location;
    String names;

    @BeforeEach
    public void before() {
        carList.add(new Car("test"));
        carList.add(new Car("java"));
        carList.add(new Car("hano"));
    }

    @Test
    public void printTest() {
        topLocationSetNameTest("test", 1);
        topLocationSetNameTest("java", 1);
        Assertions.assertThat(names).isEqualTo("test, java");
    }

    @Test
    public void printTest2() {
        topLocationSetNameTest("test", 1);
        topLocationSetNameTest("java", 1);
        topLocationSetNameTest("cafe", 2);
        topLocationSetNameTest("Bear", 1);
        Assertions.assertThat(names).isEqualTo("cafe");
    }

    private void topLocationSetNameTest(String name, int location) {
        if (this.location < location) {
            this.names = name;
            this.location = location;
        } else if (this.location == location) {
            this.names += ", " + name;
        }
    }
}
