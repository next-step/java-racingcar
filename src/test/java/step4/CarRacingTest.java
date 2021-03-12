package step4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;


class CarRacingTest {

    private CarRacing carRacing;

    @BeforeEach
    void init() {
        carRacing = new CarRacing(new String[]{"aaa","bbb"});
    }

    @DisplayName("carRacing 생성자에서 정상적으로 생성됬는지 테스트")
    @Test
    void test002() {
        List<Car> results = carRacing.getResults(new Random());

        Assertions.assertEquals(results.size(), 2);
    }

    @DisplayName("winner 테스트")
    @Test
    void test003() {
        carRacing.getResults(new Go());
        List<Car> winner = carRacing.getWinner();
        Car firstWinner = winner.get(0);
        Car secondWinner = winner.get(1);

        Assertions.assertEquals(winner.size(), 2);
        Assertions.assertEquals(firstWinner.getName(), "aaa");
        Assertions.assertEquals(secondWinner.getName(), "bbb");
        Assertions.assertEquals(firstWinner.getPosition(), 2);
        Assertions.assertEquals(secondWinner.getPosition(), 2);
    }

    @DisplayName("Random이 무조건 움직이는 번호일때 start 테스트")
    @Test
    void test004() {
        List<Car> results = carRacing.getResults(new Go());
        int position = results.get(0).getPosition();

        Assertions.assertEquals(position, 2);
    }

    @DisplayName("Random이 무조건 안움직이는 번호일때 start 테스트")
    @Test
    void test005() {
        List<Car> results = carRacing.getResults(new Stop());
        int position = results.get(0).getPosition();

        Assertions.assertEquals(position, 1);
    }



}