package racingcar.view.printer;

import racingcar.domain.Race;
import racingcar.domain.car.Car;
import racingcar.domain.car.RacingCars;

public class RacePrinter {

    private static String STATE = "-";
    private final Race race;

    public RacePrinter(Race race) {
        this.race = race;
    }

    public void print(){
        printRaceStart();
        for(int i = 0; i < race.getRaceCount(); i++){
            printPerRound(race.getRacingCarsPerRound(i));
        }
        printWinners();
    }
    private void printRaceStart(){
        System.out.println("실행결과");
    }

    private void printPerRound(RacingCars racingCars){
        for(Car car : racingCars.getCars()){
            System.out.println(car.getName()+" : "+STATE.repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printWinners(){
        StringBuilder buffer = new StringBuilder();
        for(Car car : race.getWinners()){
            buffer.append(car.getName());
            buffer.append(", ");
        }

        buffer.delete(buffer.length()-2, buffer.length()-1);
        System.out.println(buffer +"가 최종 우승하셨습니다.");
    }
}
