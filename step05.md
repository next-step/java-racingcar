- step04 에서 구현하지 못한 요구사항
    - 자동차 이름은 5자를 초과할 수 없다.
    
- step05 11월 11일 세션 리팩토링 방향
    - [정리](https://github.com/eyabc/java-racingcar/issues/2)

## 기능정리
## 기능 요구사항
- 각 자동차에 이름을 부여
- 자동차 이름은 최대 5자 -> 초과할 경우 에러 
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분한다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 기능들
- MaxLength
    - private final int maxLength;
    - private static final int defaultMaxLength = 5;

    - private MaxLength(int maxLength)
    - public static MaxLength of ()
    - public static MaxLength of (int maxLength)

    - public boolean isInBoundLength(String name) // 이름이 5자 이하인지 검사

- CarName
    - 멤버
        - 이름 private final String name
    - 생성자
        - name 을 초기화
    - 메서드
        - 이름이 비었는지 검사 private static void isBlank
        - 이름 객체 반환 public CarName getName
        
- CarPosition
    - 멤버    
        - 위치 private int position
    - 생성자
        - default 생성자
        - position 을 인자로 받는 생성자
    - 메서드
        - position 증가한 후 증가된 객체 반환 public CarPosition move
        - position 이 양수인지 검사 private void isPositiveInteger
        - CarPosition 객체 반환 public CarPosition getPosition

- Car
    - 멤버    
        - 자동차 이름 private final CarName name; 
        - 위치 정보 private CarPosition position;
    - 생성자 
        - 멤버 변수 모두 초기화 
    - 메서드 
        - 전진 public Car move 
- 자동차들 Cars
    - 멤버     
        - 자동차들 list,  private final List<Car>
    - 생성자
        - 자동차 이름의 배열 private final String[] carNames
        - 자동차들에게 일괄적으로 적용할 private final int position 
        - 자동차들에게 일괄적으로 적용할 private final MoveStrategy moveStrategy
    - 메서드
        - 자동차를 한회차 이동시킴 public void move

- Race
    - 멤버
        - 경주 횟수 private final int numberOfMoves
        - 경주에 참여시킬 자동차들 private final Cars cars;
    - 생성자
        - 경주 횟수를 검증하고 검증횟수, 경주에 참여시킬 자동차들을 초기화
    - 메서드
        - 경주 횟수 검증 (양수인지) private static void validateNumberOfMoves
        - 경주 운행 public void operate()
        - 승자를 리턴 private static String findWinner(List<Car> cars)
      
- 입력기
    - 쉼표로 구분한 자동차들이름 static public String[] readCarNames 
    - 시도 횟수 static public int readNumberOfMoves  
    
- 출력기
    - 출력기에서 race 를 호출하도록 하자
    - race 에서는 출력기를 호출해서는 안된다.
    
    - 멤버
        - 자동차 종류 private final String carKind;
    - 실행 결과 public void printRace(Race)
    - 우승 자동차 이름들 public void printWinner(Race.승자리턴 메서드)
  
