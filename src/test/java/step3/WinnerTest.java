package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Name;
import step3.domain.Position;
import step3.domain.Winners;

public class WinnerTest {

    @Test
    void 우승자_구하기(){
        List<Car> cars = Arrays.asList(
                new Car(new Name("bbb"), new Position(2)),
                new Car(new Name("vvv"), new Position(0)),
                new Car(new Name("aaa"), new Position(3))
        );
        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners).contains(new Car(new Name("aaa"), new Position(3)));
    }
}
