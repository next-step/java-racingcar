package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarRacingTest {

    @Test
    void racingTest(){
        String[] names = {"pobi", "woni", "jun"};
        int tryCnt = 5;

        CarRacing carRacing = new CarRacing(names, tryCnt);

        for(int i=0; i<tryCnt; i++){
            carRacing.race();
        }

        List<Car> cars = carRacing.getCars();
        for(Car car: cars){
            assertTrue(car.getPosition() >= 0);
        }
    }

    @Test
    void WinnersTest(){
        String[] names = {"pobi", "woni", "jun"};
        int tryCnt = 5;

        CarRacing carRacing = new CarRacing(names, tryCnt);

        carRacing.getCars().get(0).move(true);
        carRacing.getCars().get(0).move(true);
        carRacing.getCars().get(0).move(true);

        carRacing.getCars().get(1).move(true);
        carRacing.getCars().get(1).move(true);

        carRacing.getCars().get(2).move(true);

        assertEquals("pobi", carRacing.getWinners());
    }
}
