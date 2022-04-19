package step3.view;

import java.util.List;
import step3.domain.RacingHistories;

public interface Ui {

    List<String> inputCarNames();

    int inputTryCount();

    void showResult(RacingHistories results);
}
