package racing.module;

public class ManualNumberGenerator extends NumberGenerator {
    @Override
    int getNumber(int boundary) {
        return boundary;
    }
}
