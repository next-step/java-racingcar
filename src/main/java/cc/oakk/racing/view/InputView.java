package cc.oakk.racing.view;

import java.util.List;

public interface InputView {
    int readTotalNumberOfCars();
    List<String> readNameOfCars();
    int readTotalRoundCount();
}
