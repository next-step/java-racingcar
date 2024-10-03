package racingcar.controller;

import racingcar.service.RacingService;

public class ResultView {

    private ResultView() {

    }

    public static ResultView INSTANCE = null;

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }

    public void printCars(RacingService racingService) {
//        List<String> cars = racingService.getCars();
//        for (String car : cars) {
//            System.out.println(car);
//        }
//        System.out.println();
    }
}
