package racingcarwinner;



public class Game {

    public void play(){
        Cars cars = new Cars(InputView.inputCarsName());
        Rounds rounds = new Rounds(InputView.inputRoundCount());

        rounds.play(cars);

        ResultView.winnersView(WinnersPicker.winnersPick(cars));
    }
}
