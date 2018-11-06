package racinggame.domain.car;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupTest {

    CarGroup carGroup;

    @Before
    public void 레이싱그룹_카셋팅(){
        String[] carName = new String[]{"pobi","crong", "honux"};
        carGroup = new CarGroup(carName);
    }

    @Test
    public void 레이싱그룹_카생성() {
        assertThat(carGroup.getGroupCars().size()).isEqualTo(3);
    }

    @Test
    public void 레이싱그룹_전체이동() {
        carGroup.carMove(() -> true);
        int size = carGroup.getGroupCars().stream().filter(car -> car.getLocation() == 1).collect(Collectors.toList()).size();
        assertThat(size).isEqualTo(3);

    }

    @Test
    public void 레이싱그룹_전체이동안함() {
        carGroup.carMove(() -> false);
        int size = carGroup.getGroupCars().stream().filter(car -> car.getLocation() == 0).collect(Collectors.toList()).size();
        assertThat(size).isEqualTo(3);

    }
}