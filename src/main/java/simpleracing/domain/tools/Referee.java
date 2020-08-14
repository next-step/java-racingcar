package simpleracing.domain.tools;

import java.util.List;

public interface Referee<T> {

	List<T> judge(List<T> characters);
}
