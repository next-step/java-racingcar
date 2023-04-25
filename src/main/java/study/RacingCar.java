package study;

public class RacingCar {

    private int position = 1;

    public void moveForward(int randomNumberZeroToNine) {
        if (randomNumberZeroToNine >= 4) {
            this.position++;
        }

    }

    public int position() { // getPosition의 getter이름이 아닐 뿐이지, 캡슐화를 위배하는 것은 똑같지 않나요..?
        return this.position;
    }
}
