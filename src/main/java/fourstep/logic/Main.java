package fourstep.logic;


import fourstep.view.InputView;


public class Main {

    public static void main(String[] args) {

        int raceCount = InputView.inputRaceCount();
        String[] carNames = InputView.inputCarName();

        RandomNumber randomNumber = new RandomNumber();

        Race race = new Race(carNames);
        race.play(raceCount, randomNumber);
    }
}
