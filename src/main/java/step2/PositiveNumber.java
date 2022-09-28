package step2;


public class PositiveNumber
{
    private final int number;

    public PositiveNumber(String number)
    {
        this(Integer.parseInt(number));
    }

    public PositiveNumber(int number)
    {
        if (number < 0)
        {
            throw new IllegalArgumentException("음수로는 생성 할 수 없습니다.");
        }
        this.number = number;
    }

    public PositiveNumber plus(PositiveNumber number)
    {
        return new PositiveNumber(this.number + number.getNumber());
    }

    public int getNumber()
    {
        return number;
    }
}
