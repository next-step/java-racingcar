package racingcar.controller;

import racingcar.model.CarRacing;
import racingcar.view.InputHandler;
import racingcar.view.OutputRenderer;

public class RacingController {

    public void racingStart(){
        try{
            String[] carNames = InputHandler.getCarNames();
            int tryCnt = InputHandler.getTryCnt();

            CarRacing carRacing = new CarRacing(carNames, tryCnt);
            runRaces(carRacing);

            OutputRenderer.printWinners(carRacing.getWinners());
        } catch(IllegalArgumentException e){
            OutputRenderer.printError(e.getMessage());
        }
    }

    private void runRaces(CarRacing carRacing){
        for(int i=0; i<carRacing.getTryCnt(); i++){
            carRacing.race();
            OutputRenderer.printRaceStatus(carRacing.getCars());
        }
    }
}
