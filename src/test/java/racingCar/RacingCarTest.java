package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest implements NumberGenerator {
    private int[] numbers;
    private int index;

    @Override
    public int generateNumber() {
        return this.numbers[index++];
    }

    //todo 난수를 생성해서 주입하자.
    public void testNumberGenerator(int[] numbers) {
        this.numbers = numbers;
    }

    @Test
    @DisplayName("게임을 생성한다")
    void createGame() {
        int carCount = 4;
        int round = 4;

        List<Car> cars = new ArrayList<>();
        for (int number = 0; number < carCount; number++) {
            cars.add(new Car((long) number));
        }

        RacingCar racingCar = new RacingCar(cars, round);

        assertThat(racingCar.getCars().size()).isEqualTo(4);
        assertThat(racingCar.getRound()).isEqualTo(4);
    }

    @Test
    @DisplayName("1개의 자동차가 경기를 참여하여 4번 움직인다.")
    void playGame() {
        int carCount = 1;
        int round = 4;
        List<Car> cars = new ArrayList<>();

        int[] mockNumbers = {9,9,9,9};
        testNumberGenerator(mockNumbers);


        for (int number = 0; number < carCount; number++) {
            cars.add(new Car((long) number));
        }

        RacingCar racingCar = new RacingCar(cars, round);

        racingCar.playRacing();

        assertThat(racingCar.getCars().get(0).getDistance()).isEqualTo(4);
    }
}
