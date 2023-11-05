package step2;

class StringAddCalculator {

        private static final int DEFAULT_NUMBER_ZERO = 0;

        private StringAddCalculator() {
        }

        public static int splitAndSum(String text) {
                if (isEmptyOrNull(text)) {
                        return DEFAULT_NUMBER_ZERO;
                }
                return NumberCalculator.sum(NumbersTextDivider.getSplitNumbers(text));
        }

        private static boolean isEmptyOrNull(String text) {
                return text == null || text.isEmpty();
        }
}
