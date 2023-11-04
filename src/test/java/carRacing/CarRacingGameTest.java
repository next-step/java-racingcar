package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CarRacingGameTest {
    private int carCount;
    private int raceCount;
    private  CarRacingGame carRacingGame;

    @BeforeEach
    public void create(){

        carCount = 3;
        raceCount= 5;

        carRacingGame = new CarRacingGame(carCount, raceCount);
    }

    @Test
    @DisplayName("자동자 경주 객체 생성 확인")
    void 자동차경주게임_객체_생성() {

        assertThat(carRacingGame).isNotNull();

    }

    @Test
    @DisplayName("레이싱이 시작되면 사용자가 입력한 만큼 자동차 생성")
    void 자동자_count_확인(){
        carRacingGame.init();
        assertThat(carRacingGame.showCarList().size()).isEqualTo(carCount);

    }

    @Test
    @DisplayName("자동차는 값이 4 이상이면 전진")
    void 자동차_전진_확인() {
        int randomNumber = 4;

        boolean result = carRacingGame.isRide(randomNumber);

        assertThat(result).isTrue();

    }

    @Test
    @DisplayName("자동차는 값이 3 이하이면 멈춤")
    void 자동차_멈춤_확인() {
        int randomNumber = 2;

        boolean result = carRacingGame.isRide(randomNumber);

        assertThat(result).isFalse();

    }



}
