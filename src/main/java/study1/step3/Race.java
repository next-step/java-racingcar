package study1.step3;

public class Race {
    private final int raceCnt;
    private final Cars cars;

    public Race(){
        this.cars = Cars.of(InputView.getCarCnt());
        this.raceCnt = InputView.getRaceCnt();
    }

    public void race(){
        Decision moveDecisionMaker = new MoveDecision();

        ResultView.startRace();

        for(int i = 0; i < raceCnt; i++){
            cars.race(moveDecisionMaker);
            ResultView.show(cars.getCars());
        }
    }
}
