package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    Car[] cars = new Car[3];

    @DisplayName("0~9사이의 정수를 반환하는지 100번 확인한다.")
    @Test
    public void printRandomNumberTenTimes() {
        int[] check = new int[10];
        for (int i = 0; i < 100; i++) {
            int randomNumber = Race.getRandomNumber();
            System.out.println(randomNumber);
            check[randomNumber]++;
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += check[i];
        }
        assertThat(sum).isEqualTo(100);
    }

    @BeforeEach
    void init() {
        cars[0] = new Car("Foo");
        cars[1] = new Car("Foo");
        cars[2] = new Car("Foo");

        cars[0].distance = 2;
        cars[1].distance = 2;
        cars[2].distance = 2;
    }

    @DisplayName("난수가 5일때 배열의 숫자가 증가하는지 확인한다")
    @Test
    public void checkWhenRandomNumberIsFive() {
        Race.moveCarRandomly(cars[1], 5);
        assertThat(cars[1].distance).isEqualTo(3);
    }

    @DisplayName("난수가 4일때 배열의 숫자가 증가하는지 확인한다")
    @Test
    public void checkWhenRandomNumberIsFour() {
        Race.moveCarRandomly(cars[1], 4);
        assertThat(cars[1].distance).isEqualTo(3);
    }

    @DisplayName("난수가 3일때 배열의 숫자가 증가하는지 확인한다")
    @Test
    public void checkWhenRandomNumberIsThree() {
        Race.moveCarRandomly(cars[1], 3);
        assertThat(cars[1].distance).isEqualTo(2);
    }
}
