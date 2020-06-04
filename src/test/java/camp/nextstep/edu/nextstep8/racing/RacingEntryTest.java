package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;
import camp.nextstep.edu.nextstep8.stub.MoveForwardingRuleStub;
import camp.nextstep.edu.nextstep8.stub.NotMoveForwardingRuleStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingEntryTest {
    @DisplayName("Entry에 있는 자동차가 모두 움직 였을 경우 움직인 결과가 잘 반영 되는지 확인")
    @Test
    public void moveTest() {
        // given
        int carNumbers = 3;

        // when
        RacingEntry racingEntry = new RacingEntry(generateEntryList(carNumbers));
        racingEntry.move(new MoveForwardingRuleStub());

        // then
        int movedCarCount = (int) racingEntry.getEntryList().stream().filter(r -> r.getPosition() > 0).count();
        assertThat(movedCarCount).isEqualTo(carNumbers);
    }

    @DisplayName("Entry에 있는 자동차가 모두 움직이지 않은 경우 움직인 결과가 잘 반영 되는지 확인")
    @Test
    public void notMoveTest() {
        // given
        int carNumbers = 3;

        // when
        RacingEntry racingEntry = new RacingEntry(generateEntryList(carNumbers));
        racingEntry.move(new NotMoveForwardingRuleStub());

        // then
        int movedCarCount = (int) racingEntry.getEntryList().stream().filter(r -> r.getPosition() > 0).count();
        assertThat(movedCarCount).isEqualTo(0);
    }

    private List<RacingCar> generateEntryList(int carNumbers) {
        List<RacingCar> entryList = new ArrayList<>();
        for(int i = 0; i < carNumbers; i++) {
            entryList.add(new RacingCar(String.valueOf(i)));
        }
        return entryList;
    }
}

