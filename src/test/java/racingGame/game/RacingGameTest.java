package racingGame.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingGame.car.Car;
import racingGame.participant.Participants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        RacingGameRule gameRule = new CarForwardRule();
        racingGame = new RacingGame(gameRule);
    }

    @Test
    @DisplayName("참가자 설정 & 게임 수 설정 시 값에 대한 Exception 테스트")
    void participate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    racingGame.participate(null, 5);
                });
    }

    @ParameterizedTest
    @DisplayName("랜덤 반환 값을 재정의(메소드 호출마다 다르게 지정) 하여 레이싱 게임 테스트 시작 & 우승자 검증")
    @CsvSource(value = {"2:3,5,2,6,7,9:jo", "2:2,7,8,5,1,3:yohan,jo,jayden", "2:7,6,4,2,3,8:jayden"}, delimiter = ':')
    void start(int round, String input, String expectedWinner) {
        // given
        String[] split = input.split(",");
        FakeCarForwardRule fakeCarForwardRule = new FakeCarForwardRule(Stream.of(split)
                .mapToInt(Integer::parseInt)
                .toArray());
        Participants participants = new Participants("yohan,jo,jayden");

        // when
        RacingGame racingGame = new RacingGame(fakeCarForwardRule);
        racingGame.participate(participants, round);
        GameResult result = racingGame.start();

        List<Car> winners = result.getWinners();
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        //then
        assertEquals(winnerNames, Arrays.asList(expectedWinner.split(",")));
    }
}