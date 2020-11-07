package study1.step3;

public class Race {
    private int raceCnt = 0;
    private final Cars cars;

    public Race(int carCnt, int raceCnt){
        this.cars = Cars.of(carCnt);
        this.raceCnt = raceCnt;
    }

    public static Race of(int initialCarCnt, int initialRaceCnt){

        // Test가 아닐때는 0, 0을 입력한다.
        if(initialCarCnt == 0 && initialRaceCnt == 0){
            RaceSetting raceSetting = new RaceSetting();
            initialCarCnt = raceSetting.getCarCnt();
            initialRaceCnt = raceSetting.getRaceCnt();
            raceSetting.finishSetting();
        }
        return new Race(initialCarCnt, initialRaceCnt);
    }
    public void race(){
        Decision moveDecisionMaker = new MoveDecision();

        RaceBoard board = new RaceBoard();
        for(int i = 0; i < raceCnt; i++){
            cars.race(moveDecisionMaker);
            board.show(cars.getCars());
        }
    }
}
