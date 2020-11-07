package step3;

public class InputView {

    private String questionCarNumbers = "자동차 대수는 몇 대 인가요?";

    private String questionTryNumbers = "시도할 회수는 몇 회 인가요?";

    public int numberOfCars() {
        System.out.println(questionCarNumbers);
        return CarController.scanner.nextInt();
    }

    public int tryCount() {
        System.out.println(questionTryNumbers);
        return CarController.scanner.nextInt();
    }

}
