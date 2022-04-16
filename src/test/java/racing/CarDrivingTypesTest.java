package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarDrivingTypesTest {
    @Test
    @DisplayName("이동상태를 추가한다")
    void addTest() {
        List<CarDrivingType> carDrivingTypeArrayList = new ArrayList<>();
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.GO);

        CarDrivingTypes carDrivingTypes = new CarDrivingTypes(carDrivingTypeArrayList);
        assertThat(carDrivingTypes.getGoMovingCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("이동상태 GO 카운팅")
    void CountingOnlyCarDrivingTypeIsGoTest() {
        List<CarDrivingType> carDrivingTypeArrayList = new ArrayList<>();
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.STOP);
        carDrivingTypeArrayList.add(CarDrivingType.GO);

        CarDrivingTypes carDrivingTypes = new CarDrivingTypes(carDrivingTypeArrayList);
        assertThat(carDrivingTypes.getGoMovingCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("이동상태 STOP 카운팅")
    void CountingOnlyCarDrivingTypeIsStopTest() {
        List<CarDrivingType> carDrivingTypeArrayList = new ArrayList<>();
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.STOP);
        carDrivingTypeArrayList.add(CarDrivingType.GO);

        CarDrivingTypes carDrivingTypes = new CarDrivingTypes(carDrivingTypeArrayList);
        assertThat(carDrivingTypes.getStopMovingCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("모든 이동상태 카운팅")
    void CountingAllCarDrivingTypeTest() {
        List<CarDrivingType> carDrivingTypeArrayList = new ArrayList<>();
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.GO);
        carDrivingTypeArrayList.add(CarDrivingType.STOP);
        carDrivingTypeArrayList.add(CarDrivingType.GO);

        CarDrivingTypes carDrivingTypes = new CarDrivingTypes(carDrivingTypeArrayList);
        assertThat(carDrivingTypes.getAllMovingCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("모든 이동상태가 저장한다")
    void AllMovingStatusSaveTest() {
        List<CarDrivingType> dummy = new ArrayList<>();
        dummy.add(CarDrivingType.GO);
        dummy.add(CarDrivingType.GO);
        dummy.add(CarDrivingType.STOP);
        dummy.add(CarDrivingType.GO);
        dummy.add(CarDrivingType.STOP);

        List<CarDrivingType> carDrivingTypeArrayList = new ArrayList<>(dummy);
        CarDrivingTypes carDrivingTypes = new CarDrivingTypes(carDrivingTypeArrayList);

        int i = 0;
        for (CarDrivingType carDrivingType : carDrivingTypes) {
            assertThat(carDrivingType).isEqualTo(dummy.get(i));
            i++;
        }
    }

    @Test
    @DisplayName("진행된 이동상태 보다 큰 인덱스에 접근할 경우 예외가 발생한다")
    void OutOfIndexTest() {

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            List<CarDrivingType> dummy = new ArrayList<>();
            dummy.add(CarDrivingType.GO);
            dummy.add(CarDrivingType.GO);

            List<CarDrivingType> carDrivingTypeArrayList = new ArrayList<>(dummy);
            CarDrivingTypes carDrivingTypes = new CarDrivingTypes(carDrivingTypeArrayList);

            carDrivingTypes.getCarDrivingType(5);
        });

    }

}
