package step4;

import step4.dto.car.CarGroup;
import step4.dto.count.TrialCount;
import step4.dto.name.CarName;
import step4.dto.record.RecordGroup;
import step4.service.Race;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class RaceMain {

    public static void main(String[] args) {
        String delimiter = ", ";

        InputView inputView = InputView.getInstance();
        ResultView resultView = ResultView.getInstance();

        String inputName = inputView.inputCarName();
        TrialCount trialCount = inputView.inputTrialCount();

        CarName carName = new CarName(inputName);

        // 경기 시작
        Race race = new Race(carName.carNameGroup(), trialCount);
        List<RecordGroup> record = race.start();

        // 경기 종료
        resultView.renderRaceRecord(record);
        resultView.renderWinner(race.raceAwards(), delimiter);
    }
}
