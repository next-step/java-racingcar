package step3;

import java.util.Scanner;

public class InputView {

    private int numOfCars;
    private int numOfTry;

    public InputData getInputData() {
        return new InputData(numOfCars, numOfTry);
    }

    public void draw() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isNumber = false;
            while (!isNumber) {
                System.out.println("자동차 대수는 몇 대 인가요?");
                this.numOfCars = getIntegerValueFrom(scanner);
                if (this.numOfCars > 0) isNumber = true;
            }

            isNumber = false;
            while (!isNumber) {
                System.out.println("시도할 회수는 몇 회 인가요?");
                this.numOfTry = getIntegerValueFrom(scanner);
                if (this.numOfTry > 0) isNumber = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e.getCause() == null ? e : e.getCause());
        }
    }

    private int getIntegerValueFrom(Scanner scanner) {
        String value = scanner.nextLine();
        try {
            int parsedValue = Integer.parseInt(value);
            if (parsedValue <= 0) {
                System.out.println("error) 1 이상 숫자만 입력가능합니다.");
                return -1;
            }
            return parsedValue;
        } catch (NumberFormatException e) {
            System.out.println("error) 1 이상 숫자만 입력가능합니다.");
            return -1;
        }
    }

    class InputData {
        private int numOfCars;
        private int numOfTry;

        public InputData(int numOfCars, int numOfTry) {
            this.numOfCars = numOfCars;
            this.numOfTry = numOfTry;
        }

        public int getNumOfCars() {
            return numOfCars;
        }

        public int getNumOfTry() {
            return numOfTry;
        }
    }
}
