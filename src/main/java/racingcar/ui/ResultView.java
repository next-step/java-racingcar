package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.utils.Number;

import java.util.List;

public class ResultView {
    public void intro() {
        System.out.println("step4 자동차 경주");
    }

    public void enterCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void ready() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void showPlace(Car racingCar) {
        System.out.println(
                new StringBuilder(racingCar.getName())
                .append(" : ")
                .append(racingCar.getPlace())
        );
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
}
