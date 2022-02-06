package racingcar.view;

import java.util.Objects;

public class ProgressingConsole {

    private static ProgressingConsole progressingConsole = new ProgressingConsole(false, false);

    private boolean isAbNormalCarsName;
    private boolean isAbNormalRacingTime;

    public ProgressingConsole(final boolean isAbNormalCarsName,
        final boolean isAbNormalRacingTime) {
        this.isAbNormalCarsName = isAbNormalCarsName;
        this.isAbNormalRacingTime = isAbNormalRacingTime;
    }

    public static boolean isContinue(final ProgressingConsole parser) {
        return parser.equals(progressingConsole);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProgressingConsole that = (ProgressingConsole) o;
        return isAbNormalCarsName == that.isAbNormalCarsName
            && isAbNormalRacingTime == that.isAbNormalRacingTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAbNormalCarsName, isAbNormalRacingTime);
    }

}
