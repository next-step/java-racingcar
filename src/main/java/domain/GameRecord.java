package domain;

import java.util.ArrayList;
import java.util.List;

public class GameRecord {

    private LocationRecord locationRecord;
    private List<String> winners;

    public GameRecord(List<Car> cars) {
        this.locationRecord = new LocationRecord(cars);
        this.winners = new ArrayList<>();
    }

    public List<String> getWinners() {
        return winners;
    }

    public LocationRecord getLocationRecord() {
        return locationRecord;
    }

    public void saveCurrentLocation() {
        locationRecord.saveCurrentLocation();
    }

    public void checkWinners() {
        Location maxLocation = locationRecord.getMaxLocation();
        for (Location location : locationRecord.getLocations()) {
            compareWithMaxLocation(maxLocation, location);
        }
    }

    private void compareWithMaxLocation(Location maxLocation, Location location) {
        if (maxLocation.getLastLocation() == location.getLastLocation()) {
            winners.add(location.getName());
        }
    }

}
