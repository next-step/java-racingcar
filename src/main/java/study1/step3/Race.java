package study1.step3;

public class Race {
    private int raceCnt = 0;
    private final Cars cars;

    public Race(){
        RaceSetting raceSetting = new RaceSetting();
        int carCnt = raceSetting.getCarCnt();
        this.cars = Cars.of(carCnt);
        this.raceCnt = raceSetting.getRaceCnt();
        raceSetting.close();
    }

    public void race(){
        Decision moveDecisionMaker = new MoveDecision();

        RaceBoard board = new RaceBoard();
        for(int i = 0; i < raceCnt; i++){
            cars.race(moveDecisionMaker);
            board.show(cars.getCarList());
        }
    }
}
