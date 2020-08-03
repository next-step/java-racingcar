package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.rule.RacingRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SnapShotEntryTest {

    @DisplayName("해당 Entry에서 우승자 확인")
    @Test
    public void getWinnersTest() {
        // given
        Entry entry = new Entry(Arrays.asList(
                generateCar("A"),
                generateCar("B"),
                generateCar("C")));
        RacingRule alwaysGoRule = () -> true;
        Record record = new Record();

        // when
        entry.move(alwaysGoRule);
        record.keep(entry);

        // then
        assertThat(record.getFinalRoundSnapShot().getWinners()).
                containsExactly("A","B","C");
    }

    @DisplayName("외부에서 의도치 않은 접근으로 값을 변경할 때 변경이 안되는지 확인")
    @Test
    void testClone() {
        SnapShotEntry snapshot = new SnapShotEntry(Arrays.asList(generateCar("A")));
        RacingRule alwaysGoRule = () -> true;

        // copyCars 를 통해 snapshot 의 cars 값을 변경할 수가 있음
        List<RacingCar> copyCars = snapshot.getCars();
        copyCars.get(0).move(alwaysGoRule);

        assertThat(snapshot.getCars().get(0).getPosition()).isZero();
    }

    private RacingCar generateCar(String name) {
        return new RacingCar(name);
    }
}
