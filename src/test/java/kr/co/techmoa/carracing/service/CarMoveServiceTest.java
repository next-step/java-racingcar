package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.RacingCarGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMoveServiceTest {

    CarMoveService carMoveService = new CarMoveService();

    @Test
    public void moveTest() {

        //given
        RacingCarGame racingCarGame = RacingCarGame.builder()
                .carNum(3)
                .carNames("joo,ker,goekf")
                .tryNumber(5)
                .build();

        //when
        RacingCarGame resultRacingCarGame = carMoveService.move(racingCarGame);

        //then
        assertEquals(5, resultRacingCarGame.getRounds().size() );
        assertEquals(3, resultRacingCarGame.getRounds().get(0).length);
    }

}