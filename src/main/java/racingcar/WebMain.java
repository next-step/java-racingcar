package racingcar;

import racingcar.view.WebController;

public class WebMain {
    public static void main(String[] args) {
        WebController controller = new WebController();
        controller.start(8080);
    }
}
