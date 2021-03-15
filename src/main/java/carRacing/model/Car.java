package carRacing.model;

public class Car {
    private int position;

    public Car(){
        this.position = 0;
    }

    public void move(){
        this.position += 1;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
