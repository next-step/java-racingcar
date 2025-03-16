package racinggame;

import java.util.List;

public class RaceFixture {

    public static Race createRaceWithFixedRandomNumber(int fixedNumber) {
        List<Car> carList = List.of(new Car(), new Car(), new Car(), new Car());
        return new Race(carList, new FakeRandomGenerator(fixedNumber));
    }
}
