package step3;

import step3.dto.Car;
import step3.dto.Competition;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private int totalRound = 0;

    private List<Car> entryList = new ArrayList<>();

    public void initCarRace(){
        InputView inputView = new InputView();

        Competition competition = inputView.eventStart();

        totalRound = competition.getRount();

        int totalEntryCount = competition.getPaticipate();

        for(int i = 0; i< totalEntryCount; i++){
            Car racer = Car.participateRacing(i + 1, 0);
            entryList.add(racer);
        }
    }

    public void race(){

    }

    private void startRacing(){
        RacingRound round = new RacingRound();
        ResultView resultView = new ResultView();

        for(int i = 0; i< totalRound; i++){
            round.playRound(entryList);
            resultView.showCompeetitionPosition(entryList);
        }
    }

}
