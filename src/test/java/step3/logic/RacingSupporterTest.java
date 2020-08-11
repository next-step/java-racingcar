package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingSupporterTest {

    @Test
    @DisplayName("팀 이름 나누기")
    void getTeamReady() {
        assertThat(RacingSupporter.getTeamReady("포비,딸기,오랜지")).containsExactly("포비", "딸기", "오랜지");
    }

    @Test
    @DisplayName("자동차 생성 확인")
    void setCarsForRacing() {
        assertThat(RacingSupporter.setCarsForRacing(RacingSupporter.getTeamReady("포비,딸기,오랜지"))).anyMatch(el -> el.getCarName().equals("포비"));
    }

    @Test
    @DisplayName("경주 우승자 확인")
    void getWinners() {
        List<Car> cars = Stream.<Car>builder()
                .add(new Car("좐"))
                .add(new Car("포포"))
                .add(new Car("반란군"))
                .build()
                .collect(Collectors.toList());

        cars.forEach(Car::makeCarMove);

//        assertThat(RacingSupporter.getWinners(cars).size()).isGreaterThan(0);
    }
}