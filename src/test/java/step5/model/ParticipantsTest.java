package step5.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("일급 컬렉션 Participants 테스트")
public class ParticipantsTest {

    @ParameterizedTest
    @CsvSource(value = {"2"})
    @DisplayName("초기화 후 제대로 Car 객체 생성됐는지 확인")
    void check_first_collection_creation(int expected) {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim")));
        Participants partc = new Participants(cars);
        assertThat(partc.getNumberOfCars()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2"})
    @DisplayName("전략에 맞춰 첫 번째 차량만 전진 시켰을 때, 그 크기가 맞는지 확인")
    void check_first_collection_getMaximumScore(int expected) {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim")));
        cars.get(0).goForward();
        cars.get(0).goForward();
        Participants partc = new Participants(cars);
        assertThat(partc.getCurrentMaximumScoreFromParticipants()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"John"})
    void check_first_collection_getWinnerName(String expected) {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim")));
        cars.get(0).goForward();
        cars.get(0).goForward();
        Participants partc = new Participants(cars);
        assertThat(partc.getWinnerMember().get(0)).isEqualTo(expected);
    }

    @Test
    void check_first_collection_getParticipantsNameList() {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim"), new Car("Jayce")));
        Participants partc = new Participants(cars);
        assertThat(partc.getMemberOfParticipants()).containsExactly("John", "Kim", "Jayce");
    }

    @Test
    void check_first_collection_moveCarWithStrategy() {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim")));
        Participants partc = new Participants(cars);
        partc.moveCarWithStrategy(() -> true);
        partc.moveCarWithStrategy(() -> true);

        assertThat(partc.getMemberOfParticipants()).contains("John", "Kim");
    }
}
