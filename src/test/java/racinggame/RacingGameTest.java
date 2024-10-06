package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racinggame.Car.CarDto;

public class RacingGameTest {


    @Test
    public void 이동횟수만큼_이동_테스트(){
        int repeat=4;
        List<List<Integer>> repeatAndCapacities=new ArrayList<>();
        for(int i=0;i<repeat;i++){
            repeatAndCapacities.add(List.of(4,4,4,4));
        }
        RacingGame racingGame=new RacingGame(4);
        racingGame.start(repeatAndCapacities);

        List<List<CarDto>> result=racingGame.matchResult();
        for(int i=0;i<repeat;i++){
            List<CarDto> carDtos = result.get(i);
            assertThat(carDtos).isEqualTo(List.of(new CarDto(i+1),new CarDto(i+1),new CarDto(i+1),new CarDto(i+1)));
        }
    }
}
