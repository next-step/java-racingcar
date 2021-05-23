package racingCar;

import java.util.List;

public class Ready {
    private final String SPERATE_VALUE = ",";

    public String[] createPlayerList(String name) {
        return name.split(SPERATE_VALUE);
    }

    public List[] createCars(String[] playerList) {
       List[] cars = new List[playerList.length];
       int index = 0;
       for (String s : playerList) {
           cars[index] = (List) new Car(s, 0);
           index++;
       }
       return cars;
    }
}
