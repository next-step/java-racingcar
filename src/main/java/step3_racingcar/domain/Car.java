package step3_racingcar.domain;

public class Car {

	carStatusListener listener;

	public void setCarStatusListener(carStatusListener listener)
	{
		this.listener = listener;
	}

	public void move()
	{
		listener.move();
	}

	public void stop()
	{
		listener.stop();
	}

	public void status()
	{
		listener.status();
	}

	interface carStatusListener
	{
		void move();
		void stop();
		void status();
	}
}
