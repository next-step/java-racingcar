package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.generator.CarDtoTestGenerator.carDtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import racinggame.dto.CarDto;
import racinggame.dto.History;

public class SnapShotStoreTest {

    @Test
    public void 스냅샷_저장_테스트() {
        SnapShotStore snapShotStore = new SnapShotStore();
        Random random = new Random();
        List<List<CarDto>> list = new ArrayList<>();
        int repeatCount = 5;
        for (int i = 0; i < repeatCount; i++) {
            List<CarDto> carDtos = carDtos(random.nextInt(10), random.nextInt(10), random.nextInt(10),
                    random.nextInt(10));
            list.add(carDtos);
            snapShotStore.save(carDtos);
        }

        History snapShot = snapShotStore.snapShot();
        assertThat(snapShot.repeatCount()).isEqualTo(repeatCount);
        for (int i = 0; i < repeatCount; i++) {
            assertThat(snapShot.getSnapShot(i)).isEqualTo(list.get(i));
        }
    }
}
