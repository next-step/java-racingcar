package racingcar.domain.request;

public class Amount {
    private final int MINIMUM = 0;
    private int amount;

    public static Amount getInstance(String amount) {
        return getInstance(toInt(amount));
    }

    public static Amount getInstance(int amount) {
        return new Amount(amount);
    }

    private Amount(int amount) {
        if (amount <= MINIMUM) throw new IllegalArgumentException("0이하의 숫자로는 자동차를 생성할 수 없습니다.");
        this.amount = amount;
    }

    private static int toInt(String amount) {
        return Integer.parseInt(amount);
    }

    public int getAmount() {
        return 0;
    }


}
