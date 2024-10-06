package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

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

        Cars cars=racingGame.getCars();
        assertThat(cars).isEqualTo(new Cars(List.of(new Car(4),new Car(4),new Car(4),new Car(4))));
    }
}
