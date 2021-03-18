package study.step3;

public class RaceGame {

    private final InputView inputView;
    private final ResultView resultView;

    public RaceGame() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    private Cars init(){
        return Cars.of(inputView.carNames());
    }

    public void game(){
        Cars cars = init();
        int tryCnt = inputView.tryCnt();
        for(int i=0;i<tryCnt;i++){
            cars.move(new RandomMoveStrategy());
            resultView.output(cars);
        }
        resultView.winners(cars);
    }

}
