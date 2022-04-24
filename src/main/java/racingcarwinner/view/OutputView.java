package racingcarwinner.view;

import racingcarwinner.domain.Car;
import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.WinnerCars;

import java.util.List;

public class OutputView {

    public OutputView() {
        printNextLine();
        System.out.println("실행 결과");
    }

    public void printGameResult(ParticipatedCars participatedCars) {
        printNextLine();

        List<Car> participatedCarsList = participatedCars.getParticipatedCars();
        participatedCarsList.forEach(System.out::println);
    }

    public void printWinnerResult(WinnerCars winnerCars) {
        printNextLine();

        System.out.println(winnerCars.getWinnerCarsName() + "가 최종 우승했습니다.");
    }

    private void printNextLine() {
        System.out.println();
    }
}
