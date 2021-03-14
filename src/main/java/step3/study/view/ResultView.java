package step3.study.view;

import step3.study.domain.Driver;
import step3.study.dto.ResponseRacingDTO;

import java.util.List;

public class ResultView {
    public ResultView() {
        System.out.println("실행결과");
    }

    public void showResultView(ResponseRacingDTO responseRacingDTO) {
        printDistance(responseRacingDTO);
    }

    private void printDistance(ResponseRacingDTO responseRacingDTO) {
        List<Driver> driverList = responseRacingDTO.getDrivers().getDriverList();
        for (Driver driver : driverList) {
            System.out.println(driver.getNameAndNowPosition());
        }
        System.out.println();
    }

    public void printWinnerNames(List<String> winnerNameList) {
        String winnerNames = String.join(", ", winnerNameList);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
