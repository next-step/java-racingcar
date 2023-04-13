package race;

public class TestHelper {
    public static class BigPowerGenerator implements PowerGenerator {
        @Override
        public int generate() {
            return 4;
        }
    }

    public static class SmallPowerGenerator implements PowerGenerator {
        @Override
        public int generate() {
            return 3;
        }
    }
}
