public class InputVO {

    private int carNumber;
    private int tryNumber;

    public InputVO(int carNumber, int tryNumber) {
        if (carNumber < 0 || tryNumber < 0) {
            throw new IllegalArgumentException("0이상의 정수만 입력 가능합니다.");
        }
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
