package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    private int carRacingCheck(CarList carList, int playNumber){
        CarRacing carRacing = new CarRacing(carList, playNumber);
        carRacing.playAll();
        int maxPosition = 0;

        for(int i = 0; i < carRacing.getCarList().getCars().size(); i++){
            if (maxPosition < carRacing.getCarList().getCars().get(i).getPosition()) {
                maxPosition = carRacing.getCarList().getCars().get(i).getPosition();
            }
        }

        return maxPosition;
    }
    @Test
    void 자동차_전진은_플레이_수보다_더_많을_수_없다() {
        CarList carList = new CarList(Arrays.asList(new Car("woo")));
        int playNumber = 3;
        Boolean playCheck = true;
        if(playNumber < carRacingCheck(carList, playNumber))
        {
            playCheck = false;
        }
        assertThat(playCheck).isTrue();
    }
}