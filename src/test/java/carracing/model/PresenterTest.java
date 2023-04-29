package carracing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PresenterTest {

    private Presenter presenterFixture;

    @BeforeEach
    public void beforeEach() {
        this.presenterFixture = new Presenter();
        presenterFixture.addDisplay("a", List.of("-", "--", "---"));
        presenterFixture.addDisplay("b", List.of("-", "--", "---"));
        presenterFixture.addDisplay("c", List.of("-", "--", "---"));
        presenterFixture.addDisplay("d", List.of("-", "--", "---"));
    }

    @DisplayName("경주에 참가한 사람 수가 일치한다")
    @Test
    public void participates() {
        //given
        int participateCountAnswer = 4;
        //when
        //then
        assertThat(presenterFixture.participateCount()).isEqualTo(participateCountAnswer);
    }

    @DisplayName("경기 반복 횟수가 일치한다")
    @Test
    public void iteration() {
        //given
        int iterationAnswer = 3;
        //when
        //then
        assertThat(presenterFixture.iterationCount()).isEqualTo(iterationAnswer);
    }
}