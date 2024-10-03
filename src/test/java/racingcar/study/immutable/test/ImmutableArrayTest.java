package racingcar.study.immutable.test;

import org.junit.jupiter.api.Test;
import racingcar.study.immutable.example.ArrayObject;

public class ImmutableArrayTest {

    @Test
    void immutable() {
        ArrayObject arrayObject = new ArrayObject(new int[]{1, 2, 3});
        for (int one : arrayObject.getArray()) {
            System.out.println("prev = " + one);
        }
        arrayObject.getArray()[0] = 999;
        for (int one : arrayObject.getArray()) {
            System.out.println("after = " + one);
        }
    }
}


