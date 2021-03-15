package step4.domain.racing;

import step4.domain.driver.Driver;
import step4.domain.driver.car.Car;
import step4.domain.driver.name.Name;
import step4.domain.request.Participants;
import step4.domain.startegy.move.MoveStrategy;
import step4.domain.startegy.name.NameLengthLessThanFive;
import step4.domain.startegy.name.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingDrivers {

    private static final int ZERO = 0;

    private List<Driver> drivers;

    public static RacingDrivers from(Participants participants, NamingStrategy nameStrategy) {
        return new RacingDrivers(participants, nameStrategy);
    }

    private RacingDrivers(Participants participants, NamingStrategy nameStrategy) {
        drivers = generateDrivers(participants, nameStrategy);
    }

    private List<Driver> generateDrivers(Participants participants, NamingStrategy nameStrategy) {
        List<Driver> drivers = new ArrayList<>();
        String[] names = participants.getParticipants();

        for(int i=ZERO; i < names.length; i++){
            Name name = Name.from(names[i], nameStrategy);
            Car car = Car.getInstance();
            drivers.add(Driver.from(name, car));
        }

        return drivers;
    }

    public List<Driver> move(MoveStrategy moveStrategy, NamingStrategy nameStrategy) {
        return drivers.stream().peek(driver ->
                driver.move(moveStrategy)).map(driver -> Driver.newInstance(driver, nameStrategy)).collect(Collectors.toList());
    }

}
