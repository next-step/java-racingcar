package racingcar;

import racingcar.domain.Race;
import racingcar.domain.car.Car;
import racingcar.view.input.Input;
import racingcar.view.input.request.CarRequest;
import racingcar.view.printer.RacePrinter;


import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    public static void main(String[] args) {
        new Controller().main();
    }


    public void main(){
        Input input = new Input();

        int raceCount = input.inputRaceCount();
        CarRequest carRequest = input.inputCar();

        Race race = Race.from(raceCount, getCars(carRequest));
        race.race();
        new RacePrinter(race).print();

    }

    private List<Car> getCars(CarRequest carRequest) {
        return carRequest.toResource().getCars().stream()
                .map(Car::from)
                .collect(Collectors.toList());
    }
}
