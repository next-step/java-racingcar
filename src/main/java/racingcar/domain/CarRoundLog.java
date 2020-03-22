package racingcar.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CarRoundLog {
    @Getter
    List<CarLog> carLogs = new ArrayList<>();

    public void addCarLogs(String name, int position) {
        carLogs.add(new CarLog(name, position));
    }
}
