public class Car {
    int forwardCount = 0;

    public void move(int randomNumber) {
        if (!isGreaterThanOrEqual4(randomNumber)) {
            return;
        }
        this.forwardCount++;
    }

    private boolean isGreaterThanOrEqual4(int number) {
        return number >= 4;
    }
}
