import CarRacing.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCarRacingCompetition {

    Competition competition;

    @BeforeEach
    public void setUp() {
        competition = new Competition();
    }

    @Test
    @DisplayName("4보다 적은 수 입력 시 차량 이동 없음")
    public void drive_less_4() {
        int expected = 0;

        int actual = competition.drive(3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4보다 큰 수 입력 시 차량 이동")
    public void drive_more_4() {
        int expected = 1;

        int actual = competition.drive(5);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("4 입력 시 차량 이동")
    public void drive_equal_4() {
        int expected = 1;

        int actual = competition.drive(4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("winner 여러 명 확인")
    public void winner_multi_cars() {
        String[] expected = {"pobi", "crong", "honux"};

        String[] entries = {"pobi", "jk", "hyune","crong", "honux", "chunk"};
        int[] positions = {5, 2, 4, 5, 5, 1};

        competition.entryWithPosition(entries, positions);
        List<Car> winners = competition.winners();

        String[] actual = new String[winners.size()];
        for(Car car : winners) {
            actual[winners.indexOf(car)] = car.name();
        }

        assertThat(actual).isEqualTo(expected);
    }



}
