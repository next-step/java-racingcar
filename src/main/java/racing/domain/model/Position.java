package racing.domain.model;


public class Position
{
    private int position;

    private Position(int position)
    {
        this.position = position;
    }

    public static Position of(int position)
    {
        return new Position(position);
    }

    public void increase()
    {
        this.position++;
    }

    public int getPosition()
    {
        return position;
    }
}
