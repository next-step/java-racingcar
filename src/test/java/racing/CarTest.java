package racing;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 이동테스트() {
        Car car = new Car();
        car.move(true, 5);

        Map<Integer, Integer> timeTables = car.getMoveValues();
        Iterator<Integer> kyes = timeTables.keySet().iterator();

        int i = 1;
        while (kyes.hasNext()) {
            int key = kyes.next();
            assertThat(timeTables.get(key)).isEqualTo(i);
            i++;
        }
    }
}