package racingcar.view;

import java.util.Objects;

public class ProgressingConsole {

    private boolean isAbNormalCarsName;
    private boolean isAbNormalRacingTime;

    public ProgressingConsole(final boolean isAbNormalCarsName,
        final boolean isAbNormalRacingTime) {
        this.isAbNormalCarsName = isAbNormalCarsName;
        this.isAbNormalRacingTime = isAbNormalRacingTime;
    }

    public static boolean isContinue(final ProgressingConsole parser) {
        ProgressingConsole parser1 = new ProgressingConsole(false, false);
        return parser.equals(parser1);
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
