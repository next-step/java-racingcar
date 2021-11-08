package racingcar.ui.view;

import racingcar.vehicle.Vehicle;

import java.util.List;

public interface ResultView {
    void show();

    void winner();

    void append(List<Vehicle> vehicles);
}
