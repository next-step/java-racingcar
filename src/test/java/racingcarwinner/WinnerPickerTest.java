package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class WinnerPickerTest {

    @Test
    @DisplayName("우승자의 이동거리가 가장 큰 것이 맞는가")
    public void winnertravelDistanceTest(){
        int largestTravelDistance = 0;
        for (int i = 0; i < Cars.getCars().length; i++) {
            if(Cars.getCars().getTravelDistance() > largestTravelDistance){
                largestTravelDistance = Cars.getCars().getTravelDistance();
            }
        }

        for (int i = 0; i < winner.length; i++) {
            assertThat(winner[i].getTravelDistance()).isEquals(largestTravelDistance);
        }

    }

}
