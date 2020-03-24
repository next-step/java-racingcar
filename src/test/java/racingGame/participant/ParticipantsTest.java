package racingGame.participant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingGame.car.Car;
import racingGame.game.CarForwardRule;
import racingGame.game.FakeCarForwardRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipantsTest {

    private Participants participants;

    @BeforeEach
    void setUp() {
        participants = new ParticipantsV2("yohan,jo,jayden");
    }

    @ParameterizedTest
    @DisplayName("랜덤 반환 값을 재정의 하여 참가자의 기록이 제대로 기록 되는지 테스트")
    @CsvSource(value = {"2:3,5,2:0", "3:1,7,8,4:2", "2:7,6,4,8:2"}, delimiter = ':')
    void startRound(int round, String randomNumbers, int expected) {
        // given
        String[] split = randomNumbers.split(",");
        FakeCarForwardRule fakeCarForwardRule = new FakeCarForwardRule(Stream.of(split)
                .mapToInt(Integer::parseInt)
                .toArray());

        // when
        RoundScore roundScore = null;
        for (int i = 0; i < round; i++) {
            roundScore = participants.startRound(fakeCarForwardRule);
        }
        List<ParticipantScore> records = roundScore.getRecords();

        // then
        records.stream()
                .filter(score -> score.getCarName().equals("yohan"))
                .forEach(score -> assertThat(score.getPosition()).isEqualTo(expected));
    }

    @ParameterizedTest
    @DisplayName("랜덤 반환 값을 재정의(메소드 호출마다 다르게 지정) 하여 우승자 테스트")
    @CsvSource(value = {"2:3,5,2,6,7,9:jo", "2:2,7,8,5,1,3:yohan,jo,jayden", "2:7,6,4,2,3,8:jayden"}, delimiter = ':')
    void getWinner(int round, String input, String expectedWinner) {
        // given
        String[] split = input.split(",");
        FakeCarForwardRule fakeCarForwardRule = new FakeCarForwardRule(Stream.of(split)
                .mapToInt(Integer::parseInt)
                .toArray());

        // when
        for (int i = 0; i < round; i++) {
            participants.startRound(fakeCarForwardRule);
        }

        List<Car> winners = participants.getWinners();
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        // then
        assertEquals(winnerNames, Arrays.asList(expectedWinner.split(",")));
    }

}