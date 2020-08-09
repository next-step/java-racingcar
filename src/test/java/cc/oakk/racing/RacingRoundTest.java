package cc.oakk.racing;

import cc.oakk.racing.predicate.CarForwardCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingRoundTest {
    @Test
    @DisplayName("생성자의 cars의 크기가 0 이하일 때 예외발생")
    public void constructor_ShouldThrow_IllegalArgumentException_OnBelowZeroSize() {
        List<Car> dummyList = new ArrayList<>();
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingRound(dummyList, 5));
    }

    @Test
    @DisplayName("생성자 totalRoundCount 인자가 0 이하일 때 예외발생")
    public void constructor_ShouldThrow_IllegalArgumentException_OnBelowZeroArgument() {
        List<Car> dummyList = Collections.singletonList(createDummyCar());
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingRound(dummyList, 0));
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingRound(dummyList, -5));
    }

    @Test
    @DisplayName("nextRound를 최대 라운드 수 보다 넘게 호출 할 때 예외발생")
    public void nextRound_ShouldThrow_IndexOutOfBoundsException_OnBelowZero() {
        int totalRoundCount = 3;
        RacingRound racingRound = createDummyRacingRound(totalRoundCount);

        for (int i = 0; i < totalRoundCount; i++) {
            racingRound.nextRound();
        }

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(racingRound::nextRound);
    }

    private RacingRound createDummyRacingRound(int totalRoundCount) {
        return new RacingRound(Collections.singletonList(createDummyCar()), totalRoundCount);
    }

    private Car createDummyCar() {
        return new Car(new CarForwardCondition<>(c -> true, c -> c));
    }
}
