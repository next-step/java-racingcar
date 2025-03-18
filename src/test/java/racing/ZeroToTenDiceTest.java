package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class ZeroToTenDiceTest {

    @Test
    @DisplayName("ZeroToTenDice의 roll은 random.nextInt()에 bound를 10을 넣어서 호출한다. ")
    void rollTest() throws NoSuchFieldException, IllegalAccessException {
        // given
        var dice = new ZeroToTenDice();
        var randomFiled = ZeroToTenDice.class.getDeclaredField("random");
        randomFiled.setAccessible(true);
        randomFiled.set(dice, new MockRandom());

        // when
        int bound = dice.roll();

        // then
        Assertions.assertThat(bound).isEqualTo(10);

    }

    private static class MockRandom extends Random {
        @Override
        public int nextInt(int bound) {
            return bound;
        }
    }
}
