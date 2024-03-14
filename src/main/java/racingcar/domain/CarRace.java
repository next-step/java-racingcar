package racingcar.domain;

public class CarRace {

    public CarRaceResult race(String nameString, int tryCount) {
        String[] names = NameSeparator.separate(nameString);
        Cars cars = createCars(names);

        CarRaceResult carRaceResult = new CarRaceResult();
        while (tryCount-- > 0) {
            cars.move(new RandomCarMoveStrategy());
            carRaceResult.add(cars);
        }

        return carRaceResult;
    }

    private Cars createCars(String[] names) {
        return new Cars(names);
    }

}
