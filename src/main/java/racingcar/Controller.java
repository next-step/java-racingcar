package racingcar;

public class Controller {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        String[] names = inputView.getNames();
        int rounds = inputView.getRounds();
        inputView.close();

        Track track = new Track(names, rounds);

        ResultView resultView = new ResultView();

        resultView.printlnRace(track);
        resultView.printlnWinners(track.getWinners());
    }
}
