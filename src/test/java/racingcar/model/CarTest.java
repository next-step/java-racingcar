package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void Name_이름을_가진_자동차_생성() {
        String carName = "wu2ee";
        Car car = new Car(0, carName);
        assertThat(car).isEqualTo(new Car(0, "wu2ee"));
    }

    @Test
    void moveDistance_움직인_자동차_생성() {
        int moveDistance = 1;
        Car car = new Car(moveDistance, "wu2ee");
        assertThat(car).isEqualTo(new Car(1, "wu2ee"));
    }

    @Test
    void isWinner_우승한_자동차() {
        int maxDistance = 3;
        Car car = new Car(3, "wu2ee");
        assertThat(car.isWinner(maxDistance)).isTrue();
    }

    @Test
    void isWinner_우승하지_못한_자동차() {
        int maxDistance = 3;
        Car car = new Car(2, "wu2ee");
        assertThat(car.isWinner(maxDistance)).isFalse();
    }

    @Test
    void maxPosition_최대이동거리_구하기() {
        Car car = new Car(3, "wu2ee");
        assertThat(car.maxDistance(2)).isEqualTo(3);
        assertThat(car.maxDistance(4)).isEqualTo(4);
    }

    @Test
    void tryToMove_자동차가_움직인다() {
        Car car = new Car(0, "wu2ee");
        car.tryToMove(() -> 5);
        assertThat(car).isEqualTo(new Car(1, "wu2ee"));
    }

    @Test
    void tryToMove_자동차가_움직이지_않는다() {
        Car car = new Car(0, "wu2ee");
        car.tryToMove(() -> 3);
        assertThat(car).isEqualTo(new Car(0, "wu2ee"));
    }

    @Test
    void Car_처음에_움직인상태에서_다음시도에_자동차가_움직인다() {
        Car car = new Car(1, "wu2ee");
        car.tryToMove(() -> 4);
        assertThat(car).isEqualTo(new Car(2, "wu2ee"));
    }

    @Test
    void Car_처음에_움직인상태에서_다음시도에_자동차가_움직이지_않는다() {
        Car car = new Car(1, "wu2ee");
        car.tryToMove(() -> 3);
        assertThat(car).isEqualTo(new Car(1, "wu2ee"));
    }
}