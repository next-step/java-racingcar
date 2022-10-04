package step3and4.number;

@FunctionalInterface
public interface Number {

    int generatedNumber();

    final class Fake implements Number {

        private final int number;

        public Fake(int number) {
            this.number = number;
        }

        @Override
        public int generatedNumber() {
            return number;
        }

    }

}
