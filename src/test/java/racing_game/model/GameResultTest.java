package racing_game.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_game.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    String name;
    RacingCar racingCar;
    RoundResult roundResult;

    @BeforeEach
    void beforeEach() {
        this.name = "pobi";
        this.racingCar = new RacingCar(this.name);
        this.roundResult = new RoundResult();
        this.roundResult.record(racingCar);
    }

    @Test
    @DisplayName("게임 결과 Model 생성")
    void create() {
        assertThat(new GameResult().getGameResult()).isEmpty();
    }

    @Test
    @DisplayName("라운드 결과 주입")
    void record_1() {
        GameResult gameResult = new GameResult();
        gameResult.record(this.roundResult);
        assertThat(gameResult.getGameResult()).hasSize(1);
    }

    @Test
    @DisplayName("서로 다른 RoundResult 객체를 합쳤을 때, 동일한 속성 데이터 인지 확인")
    void record_2() {
        GameResult firstGameResult = new GameResult();
        firstGameResult.record(this.roundResult);

        GameResult lastGameResult = new GameResult();
        lastGameResult.record(firstGameResult);

        assertThat(lastGameResult.getGameResult().get(0)).isSameAs(firstGameResult.getGameResult().get(0));
    }

    @Test
    @DisplayName("서로 다른 GameResult 객체를 합쳤을 때")
    void record_3() {
        int size = 5;
        int testIndex = 3;

        List<RoundResult> roundResults = Stream.generate(() -> {
                    RoundResult roundResult = new RoundResult();
                    roundResult.record(this.racingCar);

                    return roundResult;
                })
                .limit(size)
                .collect(Collectors.toList());

        GameResult firstGameResult = new GameResult();
        IntStream.range(0, testIndex)
                .forEach(index -> firstGameResult.record(roundResults.get(index)));
        GameResult secondGameResult = new GameResult();
        IntStream.range(testIndex, size)
                .forEach(index -> secondGameResult.record(roundResults.get(index)));

        secondGameResult.record(firstGameResult);

        assertThat(secondGameResult.getGameResult()).hasSize(testIndex);
    }
}