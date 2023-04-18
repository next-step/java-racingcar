package nextstep;

public class StringAddCalculator {

    public int calc(String text) {
        if (!isValidText(text)) {
            return NonNegativeInteger.ZERO.getNumber();
        }
        Message msg = new Message(text);

        return splitAndSum(msg).getNumber();
    }

    private NonNegativeInteger splitAndSum(Message msg) {
        return msg.getTokens().stream()
                .map(NonNegativeInteger::new)
                .reduce(NonNegativeInteger::sum)
                .orElseThrow();
    }

    private static boolean isValidText(String text) {
        return !isEmptyText(text);
    }

    private static boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }
}
