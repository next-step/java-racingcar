package step4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class CarRacingTest {

    private CarRacing carRacing;

    @BeforeEach
    void init() {
        carRacing = new CarRacing(new String[]{"aaa","bbb"});
    }

    @DisplayName("getCurrentStatus 테스트")
    @Test
    void getReadyTest() {
        List<Car> ready = carRacing.getCurrentStatus();
        assertEquals(ready.size(), 2);
    }

    @DisplayName("winner 테스트")
    @Test
    void winnerTest() {
        carRacing.start(new Go());
        List<Car> winner = carRacing.getWinner();
        Car firstWinner = winner.get(0);
        Car secondWinner = winner.get(1);

        assertEquals(winner.size(), 2);
        assertEquals(firstWinner.getName(), "aaa");
        assertEquals(secondWinner.getName(), "bbb");
        assertEquals(firstWinner.getPosition(), 2);
        assertEquals(secondWinner.getPosition(), 2);
    }

    @DisplayName("Random이 무조건 움직이는 번호일때 start 테스트")
    @Test
    void carMoveTest() {
        carRacing.start(new Go());
        List<Car> currentStatus = carRacing.getCurrentStatus();
        int position = currentStatus.get(0).getPosition();

        assertEquals(position, 2);
    }

    @DisplayName("Random이 무조건 안움직이는 번호일때 start 테스트")
    @Test
    void carStopTest() {
        carRacing.start(new Stop());
        List<Car> currentStatus = carRacing.getCurrentStatus();
        int position = currentStatus.get(0).getPosition();

        assertEquals(position, 1);
    }
}