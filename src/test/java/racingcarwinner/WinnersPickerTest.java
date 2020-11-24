package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class WinnersPickerTest {

    @Test
    @DisplayName("우승자를 제대로 골라내는가")
    public void winnersPick(){

        Cars cars = new Cars("포비,코난,베니");
        cars.getCar(0).move();
        cars.getCar(0).move();
        cars.getCar(1).move();
        cars.getCar(1).move();
        Winners winners = WinnersPicker.winnersPick(cars);

        assertEquals(winners.getWinner(0).getName().getString(),"포비");
        assertEquals(winners.getWinner(1).getName().getString(),"코난");

    }

}
