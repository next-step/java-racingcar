package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("winners 클래스 생성시 toString 공백")
    @Test
    void when_creating_winners_class() {
        //given, when
        Winners winners = new Winners();

        //then
        assertThat(winners.toString()).isEqualTo("");

    }

    @DisplayName("우승자 한명일 경우 이름 출력")
    @Test
    void when_winner_is_one() {
        //given
        Winners winners = new Winners();

        //when
        winners.add(new Car("junho"));

        //then
        assertThat(winners.toString()).isEqualTo("junho");
    }

    @DisplayName("우승자 두명 이상 일 경우 ,로 구분지은 이름 출력")
    @Test
    void when_winner_is_two() {
        //given
        Winners winners = new Winners();

        //when
        winners.add(new Car("junho"));
        winners.add(new Car("java"));

        //then
        assertThat(winners.toString()).isEqualTo("junho,java");
    }
}