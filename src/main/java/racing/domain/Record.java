package racing.domain;

import racing.domain.model.CarName;
import racing.domain.model.Position;

public class Record
{
    private final int turn;
    private final CarName carName;
    private final Position position;

    private Record(int turn, String carName, int position)
    {
        this.turn = turn;
        this.carName = CarName.from(carName);
        this.position = Position.of(position);
    }

    public static Record of(int turn, String carName, int position)
    {
        return new Record(turn, carName, position);
    }

    public int getTurn()
    {
        return turn;
    }

    public String getCarName()
    {
        return carName.getCarName();
    }

    public int getPosition()
    {
        return position.getPosition();
    }

    public boolean isSamePosition(int position)
    {
        return this.position.getPosition() == position;
    }

    public boolean isSameTurn(int turn)
    {
        return this.turn == turn;
    }
}
