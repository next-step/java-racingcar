package com.racing.game;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import com.racing.game.entity.Car;
import com.racing.game.entity.Circuit;
import com.racing.game.entity.RaceEntry;
import com.racing.game.utils.InputUtils;
import com.racing.game.viewmodel.InputViewModel;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private Circuit circuit;

    @BeforeEach
    void setUp() {
        circuit = new Circuit();
    }

    @Test
    void carNames_split() {
        String dummy = "pobi,crong,honox";
        String[] expect = {"pobi", "crong", "honox"};
        assertLinesMatch(List.of(InputUtils.toSplitList(dummy)), List.of(expect));
    }

    @Test
    void car_isEquals() {
        assertThat(Car.from("pobi")).isEqualTo(Car.from("pobi"));
    }

    @Test
    void carNames_toCarList() {
        String dummy = "pobi,crong,honox";
        String[] expect = {"pobi", "crong", "honox"};
        assertIterableEquals(InputUtils.toCarList(dummy),
                List.of(Car.from("pobi"), Car.from("crong"), Car.from("honox")));
    }

    @Test
    void carName_5글자초과예외() {
        String dummy = "nextStep";
        assertThatThrownBy(()->{
            Car.from(dummy);
        }).hasMessageContaining("자동차 이름은 5글자를 넘어서면 안됩니다.");
    }

    @Test
    void saveCar() {
        InputViewModel viewModel = new InputViewModel(circuit);

        viewModel.readyToRace(RaceEntry.from(List.of(Car.from("pobi"))));

        assertThat(circuit.toString()).hasToString("pobi : \n\n");

        viewModel.readyToRace(RaceEntry.from(List.of(Car.from("pobi"),Car.from("popo"),Car.from("bibi"))));
        assertThat(circuit.toString()).hasToString("pobi : \npopo : \nbibi : \n\n");
    }

    @Test
    void saveTryCount() {
        InputViewModel viewModel = new InputViewModel(circuit);
        viewModel.saveLaps(5);
        assertThat(circuit.totalLaps()).isEqualTo(5);
    }

    @Test
    void resultString() {
        circuit.readyToRace(RaceEntry.from(List.of(Car.from("crong"), Car.from("honux"), Car.from("abc"))));
        assertThat(circuit.toString()).hasToString("crong : \nhonux : \nabc : \n\n");
    }

    @Test
    void car_isAhead() {
        assertThat(Car.of("pobi", 2).isAheadFrom(1)).isTrue();
    }

    @Test
    void race() {
        circuit.readyToRace(RaceEntry.from(List.of(Car.from("crong"), Car.from("honux"), Car.from("abc"))));
        circuit.saveLaps(5);

        circuit.startRace();

        assertThat(circuit.toString().split("\n\n")).hasSize(5);
    }
}
