package step5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.RacingGame;
import step5.domain.RacingRecords;
import step5.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    void Null_Check_테스트(){

        String names = null;

        assertThatThrownBy(() ->new RacingGame(names, 1))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("자동차 이름을 입력해주세요")
        ;
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void n번째_이동_결과(int tryCount){

        RacingGame racingGame = new RacingGame("kim,won,sakku", tryCount);
        MoveStrategy strategy = () -> false;

        while(!racingGame.isEnd()){
            racingGame.race(strategy);
        }

        for(int i = 0 ; i < tryCount ; i++){
            RacingRecords moveResults = racingGame.nthRacingRecords(i + 1);
            assertThat(moveResults.getRacingRecords()).hasSize(3);
        }
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void n번_이동_후_record_개수_테스트(int tryCount){

        RacingGame racingGame = new RacingGame("kim,won,sakku", tryCount);
        MoveStrategy strategy = () -> false;

        while(!racingGame.isEnd()){
            racingGame.race(strategy);
        }

        assertThat(racingGame.getRacingRecordsStorage()).hasSize(tryCount);
    }

}

