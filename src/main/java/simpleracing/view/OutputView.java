package simpleracing.view;

import java.util.List;

import simpleracing.execute.Car;

public interface OutputView {
	void addRenderingView(List<Car> cars);

	void render();
}
