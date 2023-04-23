package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


@DisplayName("Scores 테스트")
class ScoresTest {

    @DisplayName("자동차의 수와 스코어 사이즈는 동일하다")
    @Test
    void 스코어_입력_테스트() {
        Car car = new Car("test1");
        Car car2 = new Car("test2");

        Scores scores = new Scores();
        scores.addScore(new Score(car));
        scores.addScore(new Score(car2));

        Assertions.assertThat(scores.findAllScores()).size().isEqualTo(2);
    }

    @DisplayName("스코어가 가장 높은 사람이 우승한다")
    @Test
    void 우승자_찾기_테스트() {
        Scores scores = new Scores();

        scores.addScore(new Score(new Car(5, "test1")));
        scores.addScore(new Score(new Car(6, "test2")));
        scores.addScore(new Score(new Car(9, "test3")));

        List<Score> winners = scores.findWinners();

        Assertions.assertThat(winners)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(new Score(9, "test3"));
    }

    @DisplayName("우승자는 1명 이상 일 수 있다")
    @Test
    void 우승자_복수_테스트() {
        Scores scores = new Scores();

        scores.addScore(new Score(new Car(9, "test1")));
        scores.addScore(new Score(new Car(6, "test2")));
        scores.addScore(new Score(new Car(9, "test3")));

        List<Score> winners = scores.findWinners();

        Assertions.assertThat(winners.size()).isGreaterThan(1);
        Assertions.assertThat(winners.size()).isEqualTo(2);
    }

    @DisplayName("가장 높은 점수를 획득한 우승자의 이름을 확인 할 수 있다")
    @Test
    void 단일_우승자_이름_확인_테스트() {
        Scores scores = new Scores();

        scores.addScore(new Score(new Car(9, "test1")));
        scores.addScore(new Score(new Car(6, "test2")));
        scores.addScore(new Score(new Car(3, "test3")));

        List<String> winnerNames = scores.findWinnerNames();

        Assertions.assertThat(winnerNames.size()).isEqualTo(1);
        Assertions.assertThat(winnerNames)
                .usingDefaultElementComparator()
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly("test1");

    }

    @DisplayName("우승자가 여러명이면 이름도 복수로 전달받는다")
    @Test
    void 복수_우승자_이름_확인_테스트() {
        Scores scores = new Scores();

        scores.addScore(new Score(new Car(9, "test1")));
        scores.addScore(new Score(new Car(6, "test2")));
        scores.addScore(new Score(new Car(9, "test3")));

        List<String> winnerNames = scores.findWinnerNames();

        Assertions.assertThat(winnerNames.size()).isEqualTo(2);
        Assertions.assertThat(winnerNames)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly("test1", "test3");
    }
}