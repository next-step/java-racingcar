package step5.domain;

public class RelayCamera {
    public static int showLocation(int currentLocation, int location) {
        return (currentLocation > location) ? currentLocation : location;
    }
}
