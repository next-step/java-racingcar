import java.util.Scanner;


public class CarRace {
    private RacingCars racingCars;
    private final RaceRound round;

    //외부에서 생성자 호출 막기
    private CarRace(RacingCars racingCars, RaceRound round){
        this.racingCars = racingCars;
        this.round = round;
    }

    public static CarRace initRace(int numberOfCar, int round) {
        return new CarRace(RacingCars.of(numberOfCar), RaceRound.of(round));
    }

    public int getRoundValue() {
        return round.getValue();
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
    public void race() {
        for(int i=1; i<=round.getValue(); i++) {
            racing();
            recordRace(round.getValue());
        }
    }

    private void racing(){
        racingCars.getCars()
                .forEach(car -> car.moveCar(car.moveOrNot()));
    }

    private void recordRace(int count){
        System.out.println(count + "회차");
        for(int i = 0; i< racingCars.getCars().size(); i++){
            int record = racingCars.getCars().get(i).getPositionValue();
            printRecord(record);
        }
    }

    private void printRecord(int record){
        for(int j=0; j<record; j++){
            System.out.print("-");
        }
        System.out.println();
    }
}
