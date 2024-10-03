package racingcar.study.staticfactory.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * 2.호출할 때마다 새로운 객체를 생성할 필요가 없다
 */
public class BigIntegerTest {
    @Test
    void createMaxConstant() {
        String bigInteger1 = objectReference(BigInteger.valueOf(16L));
        String bigInteger2 = objectReference(BigInteger.valueOf(16L));
        String bigIntegerOutOfBoundary1 = objectReference(BigInteger.valueOf(17L));
        String bigIntegerOutOfBoundary2 = objectReference(BigInteger.valueOf(17L));

        Assertions.assertThat(bigInteger1).isEqualTo(bigInteger2);
        Assertions.assertThat(bigIntegerOutOfBoundary1).isNotEqualTo(bigIntegerOutOfBoundary2);
    }

    @Test
    void create() {
        String bigInteger1 = objectReference(BigInteger.valueOf(0));
        String bigInteger2 = objectReference(BigInteger.valueOf(0));

        Assertions.assertThat(bigInteger1).isEqualTo(bigInteger2);
    }
    @Test
    void createNegativeMaxConstant() {
        String bigInteger1 = objectReference(BigInteger.valueOf(-16L));
        String bigInteger2 = objectReference(BigInteger.valueOf(-16L));
        String bigIntegerOutOfBoundary1 = objectReference(BigInteger.valueOf(-17L));
        String bigIntegerOutOfBoundary2 = objectReference(BigInteger.valueOf(-17L));

        Assertions.assertThat(bigInteger1).isEqualTo(bigInteger2);
        Assertions.assertThat(bigIntegerOutOfBoundary1).isNotEqualTo(bigIntegerOutOfBoundary2);
    }

    private static String objectReference(BigInteger bigInteger) {
        return Integer.toHexString(System.identityHashCode(bigInteger));
    }
}
