package step3.model;

public class Car
{
    private final StringBuilder position;
    private final Move move;

    public Car(Move move)
    {
        position = new StringBuilder();
        this.move = move;
    }

    public String moving()
    {
        if (move.move())
        {
           position.append("-");
        }
        return position.toString();
    }
}
