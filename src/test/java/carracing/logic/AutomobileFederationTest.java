package carracing.logic;

import carracing.logic.type.Round;
import carracing.logic.type.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AutomobileFederationTest {
    private static final Logger log = Logger.getLogger("AutomobileFederationTest");
    private static final Map<Round, List<Score>> inputRoundToScoreListMap = Map.of(
            new Round(5), Arrays.asList(new Score(1), new Score(4), new Score(5)),
            new Round(1), Arrays.asList(new Score(7), new Score(3), new Score(9)),
            new Round(2), Arrays.asList(new Score(5), new Score(2), new Score(1)),
            new Round(3), Arrays.asList(new Score(9), new Score(4), new Score(5)),
            new Round(4), Arrays.asList(new Score(8), new Score(8), new Score(8))
    );

    AutomobileFederation federation;

    @BeforeEach
    public void beforeEach() {
        federation = new AutomobileFederation(inputRoundToScoreListMap);
    }

    @DisplayName("입력 결기경과의 수 대로 ")
    @Test
    public void run() {
        //given
        //federation.


        //when
        //then
        log.warning("테스트코드가 요구사항에 의존적이지 않고 구현에 의존적이다. 이렇게 되면 구현이 변경될때 테스트코드도 변경될 여지가 있다");
    }


}