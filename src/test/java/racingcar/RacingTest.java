package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    @DisplayName("선수 명단을 받아서 그 수만큼 경주용 차를 만들어낸다")
    public void makeCars_MakeCarListByPlayerGroupList_SizeisSame() {
        String playerGroup = "june,min,kim";

        int numberOfPlayers = playerGroup.split(",").length;
        List<Car> madeCarList = Racing.makeCars(playerGroup);

        assertThat(madeCarList.size()).isEqualTo(numberOfPlayers);
    }

    @Test
    @DisplayName("선수 이름들을 입력해서 생성된 경주용 자동차의 이름이 선수 이름들과 동일하다")
    public void makeCars_MakeCarNameListByPlayerName_SameCarNameAsPlayerName() {
        String playerGroup = "june,min,kim";
        List<String> playerGroupNameList = Arrays.stream(playerGroup.split(","))
                .map(String::new)
                .collect(Collectors.toList());

        List<Car> madeCarList = Racing.makeCars(playerGroup);
        List<String> carNameList = madeCarList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(playerGroupNameList.containsAll(carNameList)).isTrue();
    }
}
