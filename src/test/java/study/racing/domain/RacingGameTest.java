package study.racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {
    private RandomNumber randomNumber;
    private TestRandomNumber fixedRandomNumber3;
    private TestRandomNumber fixedRandomNumber5;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
        fixedRandomNumber3 = new TestRandomNumber(3);
        fixedRandomNumber5 = new TestRandomNumber(5);
    }

    @Test
    void 게임생성시_자동차_수만큼_자동차가_생성된다() {
        RacingGame racingGame = new RacingGame(3, 5, randomNumber);
        List<Car> cars = racingGame.getCars();
        assertEquals(3, cars.size());
    }

    @Test
    void 게임생성시_생성된_자동차의_초기위치는_모두0이다() {
        RacingGame racingGame = new RacingGame(3, 5, randomNumber);
        List<Car> cars = racingGame.getCars();
        assertEquals(0, cars.get(0).getPosition());
        assertEquals(0, cars.get(1).getPosition());
        assertEquals(0, cars.get(2).getPosition());
    }

    @Test
    void 랜덤숫자가_4이상이면_모든자동차가_이동을_시도한다() {
        RacingGame racingGame = new RacingGame(3, 1, fixedRandomNumber5);
        racingGame.play();

        List<Car> cars = racingGame.getCars();
        assertEquals(1, cars.get(0).getPosition());
        assertEquals(1, cars.get(1).getPosition());
        assertEquals(1, cars.get(2).getPosition());
    }

    @Test
    void 랜덤숫자가_4미만이면_모든자동차가_정지한다() {
        RacingGame racingGame = new RacingGame(3, 1, fixedRandomNumber3);
        racingGame.play();

        List<Car> cars = racingGame.getCars();
        assertEquals(0, cars.get(0).getPosition());
        assertEquals(0, cars.get(1).getPosition());
        assertEquals(0, cars.get(2).getPosition());
    }


    static class TestRandomNumber extends RandomNumber {
        private final int fixedRandomNumber;

        public TestRandomNumber(int fixedRandomNumber) {
            this.fixedRandomNumber = fixedRandomNumber;
        }

        @Override
        public int generate() {
            return fixedRandomNumber;
        }

    }
}
