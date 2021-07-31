package racing.domain;

import racing.dto.RoundResult;
import racing.dto.CarDTO;

import java.util.List;

public class OutputView {

    public void startPrintResult() {
        System.out.println("실행결과");
    }

    public void printResult(RoundResult roundResult) {
        List<CarDTO> cars = roundResult.getCars();
        for (CarDTO car : cars) {
            System.out.println(car.getName() + " : " + convertToFormat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(RoundResult roundResult) {
        System.out.println(String.join(",", roundResult.getWinners()) + "가 최종 우승했습니다.");
    }

    private String convertToFormat(int position) {
        return new String(new char[position]).replace("\0", "-");
    }

}
