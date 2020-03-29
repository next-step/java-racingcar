package domain;


import view.InputView;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingStadium racingStadium = inputView.inputGameInfo();

        GameProgress gameProgress = new GameProgress();

        gameProgress.progress(racingStadium);
    }
}
