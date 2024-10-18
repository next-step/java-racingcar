package racinggamewinner;

import org.junit.jupiter.api.Test;
import racinggamewinner.domain.Main;
import racinggamewinner.domain.WinnerList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerListTest {

    public static final int MAX_POSITION = 5;
    public static final int TEST_POSITION = 4;

    @Test
    public void addWinnerNameToList_테스트() {
        Map<String, Integer> carNameAndPositionMap = new HashMap<>();
        carNameAndPositionMap.put("red", MAX_POSITION);
        carNameAndPositionMap.put("blue", TEST_POSITION);

        WinnerList winnerList = new WinnerList(new ArrayList<>());
        winnerList.addWinnerNameToList(carNameAndPositionMap,MAX_POSITION);
        assertThat(winnerList).isEqualTo(new WinnerList(List.of("red")));
    }
}
