package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class WinnersPickerTest {

    @Test
    @DisplayName("우승자를 제대로 골라내는가")
    public void winnersPick(){

        Cars cars = Cars.createCars("포비,코난,베니");
        cars.getCar(0).move();
        cars.getCar(0).move();
        cars.getCar(1).move();
        cars.getCar(1).move();
        Winners winners = WinnersPicker.winnersPick(cars);

        assertTrue(winners.getWinner(0).equals("포비"));
        assertTrue(winners.getWinner(1).equals("코난"));

    }
}
