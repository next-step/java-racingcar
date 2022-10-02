package racing.model;

import java.util.Objects;

public class CurrentLocation {

    private static final int Min_Location = 0;

    private int currentLocation;

    public CurrentLocation(int startLocation) {
        validateLocation(startLocation);
        this.currentLocation = startLocation;
    }

    public void geStraight(){
        this.currentLocation ++;
    }
    public int compareCurrentLocation (CurrentLocation o){
        return Integer.compare(this.currentLocation, o.currentLocation);
    }
    public int getCurrentLocation(){
        return this.currentLocation;
    }
    public boolean isSameCurrentLocation(CurrentLocation comparisonCurrentLocation){
        return this.currentLocation == comparisonCurrentLocation.currentLocation;
    }
    private void validateLocation(int startLocation) {
        if (startLocation < 0) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentLocation)) return false;
        CurrentLocation that = (CurrentLocation) o;
        return currentLocation == that.currentLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentLocation);
    }
}
