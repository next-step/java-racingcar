package step5.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    void check_first_collection_creation() {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim")));
        Participants partc = new Participants(cars);
        assertThat(partc.getNumberOfCars()).isEqualTo(2);
    }

    @Test
    void check_first_collection_getMaximumScore() {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim")));
        cars.get(0).goForward();
        cars.get(0).goForward();
        Participants partc = new Participants(cars);
        assertThat(partc.getCurrentMaximumScoreFromParticipants()).isEqualTo(2);
    }

    @Test
    void check_first_collection_getWinnerName() {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim")));
        cars.get(0).goForward();
        cars.get(0).goForward();
        Participants partc = new Participants(cars);
        assertThat(partc.getWinnerMember().get(0)).isEqualTo("John");
    }

    @Test
    void check_first_collection_getParticipantsNameList() {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim"), new Car("Jayce")));
        Participants partc = new Participants(cars);
        assertThat(partc.getMemberOfParticipants()).containsExactly("John", "Kim", "Jayce");
    }

}
