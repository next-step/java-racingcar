package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingManagerTest {

    @Test
    @DisplayName("선수 명단을 받아서 그 수만큼 경주용 차를 만들어낸다")
    public void makeCars_MakeCarListByPlayerGroupList_SizeisSame() {
        String playerGroup = "june,min,kim";

        int numberOfPlayers = playerGroup.split(",").length;
        List<Car> madeCarList = RacingManager.makeCars(playerGroup);

        assertThat(madeCarList.size()).isEqualTo(numberOfPlayers);
    }

    @Test
    @DisplayName("선수 이름들을 입력해서 생성된 경주용 자동차의 이름이 선수 이름들과 동일하다")
    public void makeCars_MakeCarNameListByPlayerName_SameCarNameAsPlayerName() {
        String playerGroup = "june,min,kim";
        List<String> playerGroupNameList = Arrays.stream(playerGroup.split(","))
                .map(String::new)
                .collect(Collectors.toList());

        List<Car> madeCarList = RacingManager.makeCars(playerGroup);
        List<String> carNameList = madeCarList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(playerGroupNameList.containsAll(carNameList)).isTrue();
    }

    @DisplayName("여러 후보들 중에서 거리로 우승자를 선정할 수 있다.")
    @Test
    public void extractWinnerNames_AmongSeveralCandidate_PickWinners() {
        Car player1 = new Car("june1", 5);
        Car player2 = new Car("june2", 6);
        Car player3 = new Car("june3", 7);
        Car player4 = new Car("june4", 7);
        Car player5 = new Car("june5", 5);

        List<Car> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player5);

        List<Car> winnerList = new ArrayList<>();
        winnerList.add(player3);
        winnerList.add(player4);
        List<String> winnerNameList = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        List<String> pickWinners = RacingManager.extractWinnerNames(playerList);
        Assertions.assertThat(winnerNameList.containsAll(pickWinners)).isTrue();
    }
}
