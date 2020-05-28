package game;

public class Position {

    public int order;   //경기 순서

    public int position; //경기 결과 위치

    public Position(int order, int position) {
        this.order = order;
        this.position = position;
    }

    public int getOrder() {
        return order;
    }

    public int getPosition() {
        return position;
    }

    public static Position create(int order, int position) {
        return new Position(order, position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "order=" + order +
                ", position=" + position +
                '}';
    }
}
