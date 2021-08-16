package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.service.RacingResult;
import kr.co.techmoa.carracing.service.RacingResults;
import kr.co.techmoa.carracing.ui.dto.OutputDTO;

import java.util.List;

public class ResultView {

    private static final String MOVE_OUTPUT = "-";

    public void printResult(OutputDTO outputDTO){
        List<RacingResults> racingResultsList = outputDTO.getResults();
        viewResult(racingResultsList);
        int lastResult = racingResultsList.size() - 1;
        RacingResults racingResults = racingResultsList.get(lastResult);

        List<String> winner = racingResults.getWinner();
        viewChampion(winner);
    }
    public void viewResult(List<RacingResults> results) {
        for (int i = 0; i < results.size(); i++) {
            RacingResults resultOne = results.get(i);
            viewOneTrial(resultOne.getResults());
            System.out.println();
        }
    }

    private void viewOneTrial(List<RacingResult> cars) {
        for (int i = 0; i < cars.size(); i++) {
            viewOneCar(cars.get(i));
        }
    }

    private void viewOneCar(RacingResult result) {
        System.out.print(result.getName() + " : ");
        for (int i = 0; i < result.getPosition(); i++) {
            System.out.print(MOVE_OUTPUT);
        }
        System.out.println();
    }

    public void viewChampion(List<String> names) {
        String champions = String.join(", ", names);
        System.out.println(champions + "가 최종 우승했습니다.");
    }
}
