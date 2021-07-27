package racingcar.car;

import racingcar.view.ResultView;

public class Name {

    private String name;

    Name(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void printCarName() {
        ResultView.printCarName(this.name);
    }

}
