package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private static final String WINNER_SEPARATOR = ", ";
    private static final String DELIMITER = ",";
    private static final String WINNERS = "car1, car2, car3";
    private static final boolean MOVED = true;

    private final String carName = "car1,car2,car3";
    private final int roundCount = 3;

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(carName, roundCount, new TestMoveStrategy(MOVED));
    }

    @DisplayName("게임이 실행되면 게임 결과가 있어야 한다.")
    @Test
    void 게임결과_NULL_확인() {
        assertThat(game.play()).isNotNull();
    }

    @DisplayName("게임이 실행되면 라운드 만큼에 라운드 결과가 있어야 한다.")
    @Test
    void 게임결과_라운드결과_값_확인() {
        assertThat(game.play().getRoundResults()).hasSize(roundCount);
    }

    @DisplayName("게임이 실행되면 라운드별 결과가 있어야 한다.")
    @Test
    void 게임결과_라운드별_결과_확인() {
        for (RoundResult roundResult : game.play().getRoundResults()) {
            assertThat(roundResult.getResult()).isNotEmpty();
        }
    }

    @DisplayName("게임이 실행되면 라운드별로 자동차 진행값이 존재해야한다.")
    @Test
    void 라운드결과값확인() {
        for (RoundResult roundResult : game.play().getRoundResults()) {
            assertThat(roundResult.getResult()).hasSize(carName.split(DELIMITER).length);
        }
    }

    @DisplayName("게임이 실행되면 우승자가 존재해야 한다.")
    @Test
    void 라운드우승자확인() {
        assertThat(game.play().getWinners()).isNotEmpty();
    }

    @DisplayName("게임이 실행되면 3명의 공동우승자가 존재해야 한다.")
    @Test
    void 공동우승() {
        assertThat(game.play().getWinners()).hasSize(3);
    }

    @DisplayName("게임이 실행되면 car1, car2, car3 3명이 우승해야한다.")
    @Test
    void 공동우승자_이름검증() {
        assertThat(winnersName(game.play().getWinners())).isEqualTo(WINNERS);
    }

    private String winnersName(final List<CarResult> winners) {
        return winners.stream()
                .map(CarResult::getName)
                .collect(Collectors.joining(WINNER_SEPARATOR));
    }

}
