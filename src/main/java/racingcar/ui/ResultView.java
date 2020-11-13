package racingcar.ui;

import racingcar.domain.CarDTO;

import java.util.List;

public class ResultView {


    public void ready() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void showPlace(List<CarDTO> racingResult) {
        for (CarDTO carDTO : racingResult) {
            System.out.println(
                    new StringBuilder().append(carDTO.getName())
                    .append(" : ")
                    .append(carDTO.getPosition())
            );
        }

        System.out.println();
        System.out.println();


    }

    public void printSpace() {
        System.out.println();
        System.out.println();
    }

    public void show(String winingCars) {
        System.out.println(winingCars + " 가 우승했습니다.");
    }

    public void showRacingResult() {
        System.out.println("시험 결과");
    }

    public void printPosition(int[] raceResult) {
        for (int car=0; car<raceResult.length; car++) {
            for (int i=0; i<raceResult[car]; i++) {
                System.out.print("-");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }
}
