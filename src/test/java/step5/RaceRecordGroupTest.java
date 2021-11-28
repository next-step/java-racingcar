package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step5.dto.Car;
import step5.dto.CarName;
import step5.domain.RaceRecord;
import step5.domain.RaceRecordGroup;
import step5.dto.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class RaceRecordGroupTest {

    @Test
    @DisplayName("get 메서드는 불변한 컬렉션을 반환한다")
    public void unmodifiableTest() {
        RaceRecordGroup raceRecordGroup = new RaceRecordGroup();
        raceRecordGroup.addRaceRecord(new RaceRecord(Arrays.asList(new Car(new CarName("poby")))));

        Assertions.assertThatThrownBy(() -> {
            raceRecordGroup.getRaceRecordGroup().remove(0);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource("raceInfoArray")
    @DisplayName("우승자 이름을 반환한다")
    public void winnerTest(int count, String[] name, int[] position, String[] expectedWinner) {
        List<Car> carGroup = new ArrayList<>();
        for(int i = 0 ; i < count ; ++i) {
            carGroup.add(new Car(new CarName(name[i]), new Position(position[i])));
        }

        RaceRecordGroup raceRecordGroup = new RaceRecordGroup();
        raceRecordGroup.addRaceRecord(new RaceRecord(carGroup));

        Assertions.assertThat(raceRecordGroup.findWinners())
                .extracting((car) -> car.getName().getName())
                .contains(expectedWinner);
    }

    static Stream<Arguments> raceInfoArray() {
        return Stream.of(
                Arguments.of(3, new String[]{"pobi", "kero", "conan"}, new int[]{2,4,3}, new String[]{"kero"}),
                Arguments.of(4, new String[]{"rian", "dog", "con", "peach"}, new int[]{6,4,6,3}, new String[]{"rian", "con"}),
                Arguments.of(5, new String[]{"car1", "car2","car1", "car4", "car5"}, new int[]{1,2,3,5,5}, new String[]{"car4", "car5"}),
                Arguments.of(2, new String[]{"car1", "car2"}, new int[]{7,7}, new String[]{"car1", "car2"})
        );
    }
}
