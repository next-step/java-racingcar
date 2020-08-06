package racing.domain;

import java.util.List;

public class Victory {
    private String names;
    private int location;

    public Victory(List<Car> carList) {
        carList.stream().forEach(car -> topLocationSetName(car.getName(), car.getLocation()));
    }

    private void topLocationSetName(String name, int location) {
        if (this.location < location) {
            this.names = name;
            this.location = location;
        } else if (this.location == location) {
            this.names += ", " + name;
        }
    }

    public String getNames() {
        return names;
    }
}
