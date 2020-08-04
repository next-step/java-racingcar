import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarGameTest {

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("randomNumber 가 4 미만이면 이하의 자동차를 진행시지 않는다.")
    void notGoTest(int randomNumber) {
        FakeDiceRoller diceRoller = new FakeDiceRoller(new Random());
        diceRoller.setRandomNumber(randomNumber);
        Car car = new Car(diceRoller);
        int beforeLength = car.getLength();
        car.go();
        int length = car.getLength();

        assertThat(diceRoller.getRandomNumber()).isLessThan(DiceRoller.CRITERIA_NUM);
        assertThat(length).isEqualTo(beforeLength);
    }

    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8,9})
    @DisplayName("randomNumber 가 4 이상이면 자동차를 진행시킨다.")
    void goTest(int randomNumber) {
        FakeDiceRoller diceRoller = new FakeDiceRoller(new Random());
        diceRoller.setRandomNumber(randomNumber);
        Car car = new Car(diceRoller);
        int beforeLength = car.getLength();
        car.go();
        int length = car.getLength();

        assertThat(diceRoller.getRandomNumber()).isGreaterThanOrEqualTo(DiceRoller.CRITERIA_NUM);
        assertThat(length).isGreaterThan(beforeLength);
    }

}