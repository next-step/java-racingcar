package racingGame;

import java.util.*;

public class Car {
//<<<<<<< HEAD
	private final int RANDOM_MIN;
	private final int RANDOM_MAX;
	private static Random random = new Random();
	private int runDistance = 0;
	private String carName;

	private Car(Builder carBuilder) {
		this.carName = carBuilder.carName;
		this.RANDOM_MIN = carBuilder.FORWARD_MIN_POINT;
		this.RANDOM_MAX = carBuilder.FORWARD_MAX_POINT;
	}
//=======
//
//    private static final int FORWARD_LIMIT = 4;
//    private static final int RANDOM_MIN = 0;
//    private static final int RANDOM_MAX = 9;
//    private static Random random = new Random();
//    private int runDistance = 0;
//    private String carName;
//
//    private Car(Builder carBuilder) {
//        this.carName = carBuilder.carName;
//    }
//
//    public void run() {
//        if (randomRangeValue() >= FORWARD_LIMIT) {
//
//    private static Random random = new Random();
//    private int runDistance = 0;
//
//    public void run() {
//        int forward = 0;
//        forward = random.nextInt();
//
//        if (forward >= 4) {
//            runDistance++;
//        }
//    }
//>>>>>>> 8ba7664d1f8f43d9c7aa172edf7bdc8f735ea663

	// Builder Class
	public static class Builder {
		private String carName;
		private int FORWARD_MIN_POINT;
		private int FORWARD_MAX_POINT;

		public Builder carName(String carName) {
			this.carName = carName;
			return this;
		}

		public Builder runMinPoint(int minPoint) {
			this.FORWARD_MIN_POINT = minPoint;
			return this;
		}

//<<<<<<< HEAD
		public Builder runMaxPoint(int maxPoint) {
			this.FORWARD_MAX_POINT = maxPoint;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}
//=======
//    @Override
//    public String toString() {
//        return this.carName + ": " + printDistance();
//    }
//>>>>>>> 8ba7664d1f8f43d9c7aa172edf7bdc8f735ea663

	public void run(int forwardLimit) {
		if (randomRangeValue() >= forwardLimit) {
			this.runDistance++;
		}
	}

	public static int getWinDistance(List<Car> cars) {
		int winDistance = 0;
		for (Car car : cars) {
			winDistance = winDistance > car.getRunDistance()
					? winDistance
					: car.getRunDistance();
		}
		return winDistance;
	}

	public static List<Car> getWinCars(List<Car> cars, int winDistance) {

		// 스트림을 사용하여 최대값이 같을 시 중복을 허용하여 구하는 방법을 모르겠음
//		final Comparator<Car> carCom = (c1, c2) -> Integer.compare(c1.getRunDistance(), c2.getRunDistance());
//		List<Car> winCars = Arrays.asList(cars.stream().max(carCom).get());

		List<Car> winCars = new ArrayList<>();

        for (Car car: cars) {
	        inputWinnerCars(winCars, car, winDistance);
        }
		return winCars;
	}

	private int randomRangeValue() {
		return random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
	}

    public static void inputWinnerCars(List<Car> winCars, Car car, int winnerDistance) {
		if (car.getRunDistance() >= winnerDistance) {
			winCars.add(car);
		}
    }
//<<<<<<< HEAD

	public int getRunDistance() {
		return runDistance;
	}

	public String getCarName() {
		return this.carName;
	}

	@Override
	public String toString() {
		return this.carName + ": " + printDistance();
	}

	private String printDistance() {
		String distance = "";
		for (int i = 0; i < this.runDistance; i++) {
			distance += "-";
		}
		return distance;
	}

//=======
//
//    public int getRunDistance() {
//        return runDistance;
//    }
//>>>>>>> 8ba7664d1f8f43d9c7aa172edf7bdc8f735ea663
}
