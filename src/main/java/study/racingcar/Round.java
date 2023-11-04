package study.racingcar;

public class Round {

    private final Cars participateCars;

    public Round(Cars cars) {
        this.participateCars = cars;
    }

    public void race(ScoreBoard scoreBoard) {
        participateCars.carlist().forEach(car -> {
            car.canMove();
            Score score = new Score(car);
            saveScore(scoreBoard, score);
        });
    }

    private void saveScore(ScoreBoard scoreBoard, Score score) {
        scoreBoard.score(score);
    }

    public Cars participateCars(){
        return participateCars;
    }
}
