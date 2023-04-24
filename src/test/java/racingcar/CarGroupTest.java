package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroupTest {


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

        List<String> pickWinners = CarGroup.extractWinnerNames(playerList);
        Assertions.assertThat(winnerNameList.containsAll(pickWinners)).isTrue();
    }

}
