package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    public void setUp(){
        cars = new Cars(3);
    }

    @DisplayName("DiceWithInput을 사용,  4보다 작을때 ")
    @Test
    public void playGameLess() {

        cars.playGame(new DiceWithInput(2));
        List<Integer> positionList = cars.getPositionList();

        assertThat(positionList).contains(0,0,0);
    }

    @DisplayName("DiceWithInput을 사용, 4보다 클때")
    @Test
    public void playGameGrater(){
        cars.playGame(new DiceWithInput(4));
        List<Integer> positionList = cars.getPositionList();

        assertThat(positionList).contains(1,1,1);
    }
}