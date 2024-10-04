package javaracingcarwinner.controller;


import javaracingcarwinner.dto.GameSettingDto;
import javaracingcarwinner.entity.RacingCar;
import javaracingcarwinner.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaRacingCarWinnerTest {
    private ResultView resultView;

    @BeforeEach
    void init() {
        this.resultView = new ResultView();
    }

    @Test
    void split_리스트_사이즈_검증() {
        JavaRacingCar javaRacingCar = new JavaRacingCar(new GameSettingDto("pobi,crong,honux", 5), resultView);
        List<RacingCar> cars = javaRacingCar.cars();
        assertThat(cars).hasSize(3);
    }

    @Test
    void 이름_5자_넘을_시_예외() {
        assertThatThrownBy(() -> new JavaRacingCar(new GameSettingDto("pobi,crong,honux,jeonghyeonkwon", 5), resultView)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 입력된_시도_횟수_검증() {
        JavaRacingCar javaRacingCar = new JavaRacingCar(new GameSettingDto("pobi,crong,honux", 5), resultView);

        assertThat(javaRacingCar.tryCount()).isEqualTo(5);
    }

    @Test
    void 입력된_시도_횟수_negative_value() {
        assertThatThrownBy(() -> new JavaRacingCar(new GameSettingDto("pobi,crong,honux", -4), resultView)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 우승자_검증_1명() {
        List<RacingCar> cars = new ArrayList<>();

        cars.add(new RacingCar("pobi",3));
        cars.add(new RacingCar("kwon",1));

        List<RacingCar> winners = JavaRacingCar.whoIsWinners(cars);

        assertThat(winners).hasSize(1);

        RacingCar who = winners.get(0);

        assertThat(who.name()).isEqualTo("pobi");

    }

    @Test
    void 우승자_검증_공동() {
        List<RacingCar> cars = new ArrayList<>();

        cars.add(new RacingCar("win",3));
        cars.add(new RacingCar("win2",3));
        cars.add(new RacingCar("win3",3));
        cars.add(new RacingCar("loser",1));

        List<RacingCar> winners = JavaRacingCar.whoIsWinners(cars);

        assertThat(winners).hasSize(3);

        assertThat(winners.stream().map(w -> w.name()).toArray()).contains("win", "win", "win3");
    }
}
