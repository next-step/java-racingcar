package racingcar.utils;

public interface NameChecker {
    String[] splitName(String inputLine);
    boolean checkAvailableCarName(String carName);
}
