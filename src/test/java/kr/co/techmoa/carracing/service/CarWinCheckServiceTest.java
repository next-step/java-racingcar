package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.Position;
import kr.co.techmoa.carracing.service.move.MoveStategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarWinCheckServiceTest {

    CarWinCheckService carWinCheckService = new CarWinCheckService();

    @Test
    void 우승자_한명_test() {
        int[] totalCarResult = new int[]{2,3,4,5};

        List<Integer> winList = carWinCheckService.checkGameResult(totalCarResult);

        assertEquals(1, winList.size() );
        assertEquals(5, winList.get(0) );
    }

    @Test
    void 우승자_복수_test() {
        int[] totalCarResult = new int[]{2,3,5,5};

        List<Integer> winList = carWinCheckService.checkGameResult(totalCarResult);

        assertEquals(2, winList.size() );
        assertEquals(5, winList.get(0) );
        assertEquals(5, winList.get(1) );
    }
}