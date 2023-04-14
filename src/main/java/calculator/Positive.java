package calculator;

public class Positive {
    public Positive() {
    }

    public int sumPositiveNumbers(int[] numbers) {
        int addNumber = 0;

        for (int num : numbers) {
            this.checkPositive(num);

            addNumber += num;
        }

        return addNumber;
    }

    public int[] toPositiveInts(String[] str) {
        final int[] positiveList = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            final int parsedInt = Integer.parseInt(str[i]);
            this.checkPositive(parsedInt);

            positiveList[i] = parsedInt;
        }

        return positiveList;
    }

    private void checkPositive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }
}
