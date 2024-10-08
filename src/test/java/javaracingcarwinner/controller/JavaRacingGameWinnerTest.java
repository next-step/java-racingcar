package javaracingcarwinner.controller;


import javaracingcarwinner.dto.GameSettingDto;
import javaracingcarwinner.entity.RacingCar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class JavaRacingGameWinnerTest {

    @Test
    void split_리스트_사이즈_검증() {
        JavaRacingGame javaRacingGame = new JavaRacingGame(new GameSettingDto("pobi,crong,honux", 5));
        List<RacingCar> cars = javaRacingGame.getCars();
        assertThat(cars).hasSize(3);
    }

    @Test
    void 이름_5자_넘을_시_예외() {
        assertThatThrownBy(() -> new JavaRacingGame(new GameSettingDto("pobi,crong,honux,jeonghyeonkwon", 5))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 입력된_시도_횟수_negative_value() {
        assertThatThrownBy(() -> new JavaRacingGame(new GameSettingDto("pobi,crong,honux", -4))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 우승자_검증_1명() {
        List<RacingCar> cars = new ArrayList<>();

        cars.add(new RacingCar("pobi", 3));
        cars.add(new RacingCar("kwon", 1));

        List<RacingCar> winners = JavaRacingGame.whoIsWinners(cars);

        assertThat(winners).hasSize(1);

        RacingCar who = winners.get(0);

        assertThat(who.name()).isEqualTo("pobi");

    }

    @Test
    void 우승자_검증_공동() {
        List<RacingCar> cars = new ArrayList<>();

        cars.add(new RacingCar("win", 3));
        cars.add(new RacingCar("win2", 3));
        cars.add(new RacingCar("win3", 3));
        cars.add(new RacingCar("loser", 1));

        List<RacingCar> winners = JavaRacingGame.whoIsWinners(cars);
        List<String> names = winners.stream().map(w -> w.name()).collect(Collectors.toList());

        assertAll(
                () -> {
                    assertThat(names).hasSize(3);
                },
                () -> {
                    assertThat(names).contains("win", "win2", "win3");
                }
        );

    }

}
