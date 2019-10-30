package racingcar.business;

public class RandomValueDriveWay implements DriveWay {

    public boolean isEnableToMove() {
        return (int) (Math.random() * 10) > 3;
    }
}
