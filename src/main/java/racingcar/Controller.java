package racingcar;

import racingcar.car.Car;
import racingcar.input.Input;
import racingcar.input.request.CarRequest;

import java.util.stream.Collectors;

public class Controller {

    public static void main(String[] args) {
        new Controller().main();
    }


    public void main(){
        Input input = new Input();

        int raceCount = input.inputRaceCount();
        CarRequest carRequest = input.inputCar();

        Race race = Race.from(raceCount, carRequest.toResource().getCars().stream().map(Car::from).collect(Collectors.toList()));
        race.race();
    }
}
