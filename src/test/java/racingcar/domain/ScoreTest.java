package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Score 객체 테스트")
public class ScoreTest {

    @Test
    void Score_객체를_자동차_객체로_생성하면_자동차의_이름과_포인트를_확인할수있다 () {
        Score score = new Score(new Car(1, "korea"));

        Assertions.assertThat(score.findPoint()).isEqualTo(1);
        Assertions.assertThat(score.findCarName()).isEqualTo("korea");
    }

    @Test
    void Score_객체를_직접_포인트와_자동차_이름으로_생성할수도_있다 () {
        Score score = new Score(3, "abc");

        Assertions.assertThat(score.findPoint()).isEqualTo(3);
        Assertions.assertThat(score.findCarName()).isEqualTo("abc");
    }
}
