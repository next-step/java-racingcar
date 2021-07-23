package step3.domain;


import org.junit.jupiter.api.Test;

class CarRacingGameTest {

    @Test
    void doNothing() {
        CarRacingGame carRacingGame = new CarRacingGame(3, 5);
        carRacingGame.gameStart();

        // 이후에 뭘 어떻게 검증해야 할까?
    }
}