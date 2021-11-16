package racingcar.view;

import racingcar.domain.*;

import java.util.List;

public class RacingCarResultView {

    private static final String DASH = "-";

    public void output(GameResultData result) {
        this.printRace(result);
        this.printVictoryUser(result);
    }

    public void printRace(GameResultData result) {
        Records records = result.getRecords();
        List<Record> recordList = records.getRecordList();
        for(int i = 0; i < recordList.size(); i++) {
            RacingCars racingCars = recordList.get(i).getCars();
            RacingCarResultView.print(racingCars);
            System.out.println();
        }
    }

    public static void print(RacingCars cars) {

        List<RacingCar> carList = cars.getCars();
        for(int i = 0; i < carList.size(); i++) {
            String carPosition = printCar(carList.get(i));
            System.out.println(carPosition);
        }
    }

    public static String printCar(RacingCar car) {
        int value = car.getLocation();
        String result = car.getCarName().getName() + ": -";

        for(int i = 0; i < value; i++) {
            result += DASH;
        }

        return result;
    }

    public void printVictoryUser(GameResultData result) {
        System.out.println(result.getVictoryUsers() + "가 최종 우승했습니다!!");
    }

}
