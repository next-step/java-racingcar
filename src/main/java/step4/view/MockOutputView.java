package step4.view;

import step4.domain.RacingCar;

import java.util.ArrayList;

public class MockOutputView implements OutputView {
    private final ArrayList<String> outputs = new ArrayList<>();

    @Override
    public void print(String message) {
        outputs.add(message); // 출력 메시지를 리스트에 저장
    }

    @Override
    public void startAndPrintRacing(RacingCar racingCar) {
        int raceCount = 0;
        while (racingCar.compareNumberOfRace(raceCount++) > 0) {
            racingCar.doRacing();

            RacingCarResultView.printRacingCarStatus(this, racingCar);
        }
        RacingCarResultView.printRacingCarWinner(this, racingCar);
    }

    public ArrayList<String> getOutputs() {
        return this.outputs;
    }
}