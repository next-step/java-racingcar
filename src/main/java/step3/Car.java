package step3;

import java.util.Random;

public class Car implements CarMoveStrategy {
    // 구현이 아니라 생성자로 주입이면 , CarMoveStrategy 에서 가진 상태값 을 가져다가 써야하는 상황으로
    // 생각이 드는데요.... 아무리 요리 조리 생각을 해봐도 전해주신
    /*

    ###다른 코멘트에서 언급한 차의 움직임을 결정하는 전략 인터페이스를 인스턴스 변수로 가지고, 생성자를 통해 주입받는 건 어떨까요???:)
    ###그리고 move()에서는 해당 인터페이스의 메소드를 통해 차의 움직임을 결정하는거죠!

    */
    // 위 말씀이 잘 이해가 안되서 구현을 못하고 해매고 있네요 ㅠㅠ

    // Upper class 는 canMove 한개고... 힌트 접근을 잘못한건지 어렵네요....

    // 전략패턴을 활용하라고 힌트를 주신거 같아서 관련 내용을 살펴보고 적용해보려고 해도
    // 어떤 행위 ( 여기서는 move 같은? ) 의 구현부분을 만드는 것도 아닌거 같고....
    // move 클래스를 간다/안간다 로 나누는게 맞는건지 , 그리고 canMove 에서 얻은 boolean 값으로 분기??
    // 몇 일을 싸매고 요리 조리 해보려고 해도 답이 나오질 않아 ㅠㅠ 미완된 상태로 우선 리뷰를 재차 부탁 드려봅니다.

    static final Random random = new Random();

    // 구분
    int carNumber;
    CarMoveStrategy carMoveStrategy;

    private void Car() {
    }

    public void Car(int carNumber, CarMoveStrategy carMoveStrategy) {
        this.carNumber = carNumber;
        this.carMoveStrategy = carMoveStrategy;
    }

    public void move() {
        int movingCnt = getMoveCount();
        location = (movingCnt > MOVE_START_AT) ? location + movingCnt : location;

        // 밑에랑 비슷한 의문이 드는 부분인데, 한 번의 random함수 호출로 해당 값이 가부 결정 여부도 중요하지만
        // 4 이상의 값이 나오면 move 도 행해야 하는데 canMove 를 별도로 boolean 값을 얻은 후에
        // move 에서 필요한 값은 어떻게 처리해야 하는가? 가 큰 의문입니다.

        // 재차 random 으로 값을 호출하면 4 이하가 나오거나 ? 4 이상이 나온다 한들 그럼 canMove 가 의미가 있나 ?
        // 하는 궁금증이 계속 생기네요..

    }

    @Override
    public boolean canMove() {
        movingCnt = random.nextInt(MAX_MOVE_LIMIT);
        location = (movingCnt > MOVE_START_AT) ? location + movingCnt : location;
        /*
        return 값은 boolean 값인데,
        이 동작 후에는 이 동작에서 랜덤으로 발생한 movingCnt
        즉 int 값이 리턴되거나 유지되어 있어야 한다고 생각이 들어요
        즉 4 이상의 값에서는 움직일 칸수 만큼의 값을 유지시켜야 하는데
        단순히 가/부 여부만 리턴하면 move 를 재호출할 때 movingCnt 를 random 으로 재 생성 해야 되는건지..
        막혀서 해매네요 ;;;;;

        */

        return true;
    }


    public int getMoveCount() {
        return random.nextInt(MAX_MOVE_LIMIT);
    }

    public int getLocation() {
        return location;
    }

}
