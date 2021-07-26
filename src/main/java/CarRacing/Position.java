package CarRacing;

public class Position {

    private int position = 0;
    private StringBuffer sb = new StringBuffer();


    public void move(int carMove) {
        if (carMove > 3) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
