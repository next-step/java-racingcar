package study.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RealCarTest {
    @Test
    @DisplayName("이동 결과는 true 또는 false 가 나온다")
    void move() {
        RealCar realCar = new RealCar("blue");
        Set<Boolean> results = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            realCar.move();
            results.add(realCar.isMoved());
        }
        assertThat(results).contains(true, false);
    }

    @Test
    @DisplayName("자동차 이름이 5자가 넘으면 오류메시지를 출력한다.")
    public void whenCarNameOverFiveChar() {
        assertThatThrownBy(() -> new RealCar("yellow")) //
                .isInstanceOf(IllegalArgumentException.class) //
                .hasMessage("이름은 5자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("이동 시도횟수를 반환한다.")
    void totalMoves() {
        Car car = new RealCar("blue");
        car.move();
        car.move();
        car.move();

        assertThat(car.getTotalTry()).isEqualTo(3);
    }

    @Test
    @DisplayName("실제 이동거리를 반환한다.")
    void distanceDriven() {
        TestingCar car = new TestingCar();
        car.move(false);
        car.move(true);
        car.move(true);
        car.move(false);

        assertThat(car.getDistanceDriven()).isEqualTo(2);
    }

    private static class TestingCar extends RealCar {
        private boolean nextGuess;

        public TestingCar() {
            super("blue");
        }

        @Override
        protected boolean guessMove() {
            return nextGuess;
        }

        public void move(boolean nextGuess) {
            this.nextGuess = nextGuess;
            super.move();
        }
    }
}
