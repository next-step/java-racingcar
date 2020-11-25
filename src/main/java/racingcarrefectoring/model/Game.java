package racingcarrefectoring.model;

public class Game {

    private final Cars cars;
    private final Rounds rounds;

    public Game(String carsName, int roundCount){
        cars = new Cars(carsName);
        rounds = new Rounds(roundCount);
    }

    public Winners play(){
        rounds.play(cars);
        return WinnersPicker.winnersPick(cars);
    }
}
