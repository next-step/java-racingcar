import vo.*;

public class StringAddCalculator {

    public static int splitAndSum(String value) {
        SplitTarget target = SplitTarget.of(value);
        SplitStrings splitStrings =  target.split();
        PositiveIntegers positiveIntegers = splitStrings.toIntegers();
        return positiveIntegers.sum();
    }
}
