package racingcar;

public class CarArray {
    Car[] mCarArray;
    int mNumOfCar;

    public CarArray()
    {
        mNumOfCar = 0;
        mCarArray = new Car[0];
    }
    public CarArray(int mNumOfCar)
    {
        this.mNumOfCar = mNumOfCar;
        mCarArray = new Car[mNumOfCar];
    }

    public void InputCarArray(int NumOfCar)
    {
        this.mNumOfCar = mNumOfCar;
        mCarArray = new Car[mNumOfCar];
    }

    public void updateCarArrayPosition()
    {
        for (int i = 0; i < mNumOfCar; i++)
        {
            mCarArray[i].updatePosition();
        }
    }

    public int position(int carPosition)
    {
        return mCarArray[carPosition].position();
    }

}
