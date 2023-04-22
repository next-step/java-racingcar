# next-step cleancode 16기 김동훈
- 개요 : 코드리뷰사항 정리

## PR 링크 정리
- step1 : https://github.com/next-step/java-racingcar/pull/4253
- step2 : https://github.com/next-step/java-racingcar/pull/4284
- step3 : https://github.com/next-step/java-racingcar/pull/4323
- step4 : 
- step5 : undefined


## 느낀점
- 좋은코드란?
  - 나쁜짓을 하지 않는 코드
  - 기능이 동작하는 코드
  - 검증(테스트)하기 좋은 코드
  - 원칙을 지키는 코드
  - 짧고 간결하고 이해하기 쉬운 코드

## 2차 강의에서

### 절차지향적인 개발 방식
- 상태값을 꺼내사 객체 밖에서 로직을 구현한 부분 : getter method 가 보일때 의심해보자
```
//before
private static int maxPosition(List<Car> cars) {
    int maxPosition = 0;
    for(Car car : cars) {
        if(maxPosition < car.getPostition() ) {
            maxPosition = car.getPostition;
        }
    }
    return maxPosition;
}
```


## 리뷰사항 정리 (step3)

### step3 - 1차 리뷰사항
```text
몇 가지 의견 드립니다. 👍 당부말씀도 함께 드리겠습니다.

미션을 접근하시는 방식이 너무 복잡하고, 어렵습니다. AutomobileFederation 과 같은 클래스는 설계의 의도를 쉽게 이해하기 어렵습니다.
쉽고 단순하게 접근하는 것을 추천드립니다. 우리가 설계하는 자동차 경주에는 "자동차" 와 "경주" 만 있으면 됩니다. 그게 답니다. 그 이상의 무언가가 필요없습니다.
메소드의 리턴 타입이 Map 인 것 치고 좋은 설계인 경우를 거의 못 보긴 했습니다. 클래스 분리를 두려워 마시고 적극적으로 시도해 보시기 바랍니다.
질문에 대한 답변은 별도 댓글로 드리겠습니다. 🙇
```

### 과도하게 복잡한 자료구조

```
public Map<Round, List<Score>> racingStart(int participate, int iterations) {
```

- Round 가 List<Score> 도 관리하면 안 되나요? 이 메소드의 리턴 타입을 보고, 그런 생각이 들었습니다.
  - Round가 결정되면 그에 해당하는 List 가 결정되도록 하는 구조를 가져가고 싶은데요, Round가 결정되면 그에 해당하는 List 를 관리하는 책임을 외부에 노출시켜서 복잡도가 올라간거같습니다.
  - List 를 관리하는 책임을 Round 내부로 이동시키는 방향으로 수정

### Model(혹은 Domain) 간의 관계 정리 필요

```text
private final Map<Round, List<Score>> roundToScoreListMap;
private final Map<Round, Record> roundToRecordMap;
```
- Round -> Record -> Score 간의 관계 정립이 좀 되어야 할 것 같다는 생각이 듭니다.
- 제가 보기엔, Record Score 모두 Round 가 관리하면 되는 정보들입니다.
  - 네 맞습니다 Round가 결정되면 Score, Record 모두 결정되므로 Round 의 책임으로 괸리하는 방향이 맞는듯 합니다
  - Round 가 관리하는 정보들로 수정

### 데이터의 저장과 출력형태표현 의 구분
```text
public class Record {
    private final List<String> recordStringList;
```
- 자동차 경주의 기록이라는 "데이터"가 처음부터 문자열일 수 있나요? 요게 좀 마음에 걸립니다.
- 문자열은 "표현"의 형태일 것 같은데 어떻게 생각하시나요?
- (해설1) : 자동차 경주기록은 어디까지 움직였는지 숫자로 저장되어야 함. 
- (해설2) : 문자열로 경주기록이 표현되는거라고 해서, 꼭 데이터 저장을 문자로 할필요 없음
- (해결3) : 모델에서는 >> 데이터는 어떻게 자료를 저장해야하는지만 고민하고, 표현에서는 저장된 데이터를 어떻게 표시할지만 고민하면 된다


### 쓸데없이 복잡하게 구현하지 말기
```text
public class RaceApplication {
    private static final Map<Class<?>, Object> ioc = new HashMap<>();
```
- 처음보다도 더 난해해졌음
- IoC 콘테이너를 지금 단계에서 너무 인위적으로 구현하려고 노력하지 마시기 바랍니다. 
- 어차피 제대로 된 구현이 나올 수도 없고, 
- 미션을 한 스텝씩 진행하시면서 자연스럽게 다양한 시나리오를 경험하시면 되니 너무 앞서가지 마시기 바랍니다.
- 내생각
  ```text
  아하... 네 이부분은.. 저도 구현하면서.. 이게 맞나..? 싶었는데.. 사실 이게 포비가 말씀하신 OOP적으로도 좋은 구조를 가져가야지! 라는 생각은 했는데,...
  이게 사실 프레임워크 없이 좋은 구조를 가지고있는 OOP 프로젝트를 한 경험이 없다보니.. 조금 배우고 익숙한 방향이 옳은 방향이겠거니 해서.. 이렇게 되버린거 같은데.. 만들고나니까 좀.. 뿌듯한게 있네요.. 물론 오버엔지니어링이라는 의견에는 완전히 동의합니다..!
  ```

### 일급 콜렉션 객체로의 역할과 방어적 복사
```text
public List<Score> getScores() {
    return scores;
}

public List<Record> getRecords() {
    return records;
}
```
- 일급 콜렉션 객체로의 역할을 유지하려면 이 값들을 복사한 새로운 List 객체를 반환하는 것이 좋은 선택일 것 같습니다.
  - 좋은 의견 감사합니다. 말씀듣고보니 방어적 복사가 필요한 부분이라 말씀하신대로 새로운 List 를 생성하고 Deepcopy를 수행해서 리턴하게 변경했습니다


### (스터디노트) 일급 콜렉션 객체란!
```text

```

### 애매모호하고 어려운 메서드의 이름
```text
public String toProgress() {
    return value >= THRESHOLD ? PROGRESS : STOP;
}
```
- .toProgress() 라는 메소드명이 어렵게 느껴집니다. 점수판에서의 표현에 관한 메소드 아닌가요? 더 좋은 메소드 이름을 고민해 주시면 좋겠네요.
  - 듣고나니 부적절한 이름이였다는 생각이 듭니다 render() 로 수정하였습니다


### Thread-Safe
```
private final Scanner scanner;
private final PrintStream printStream;
```
- 둘 다 thread safe 한가요?
  - PrintStream 은 thread safe 하지 못하고 여기저기서 공유되서 쓰이면 문제가 생길 가능성이 높다고 생각합니다. 그래서 해당 InputPresentation 클래스가 생성될때마다 다른 PrintStream 을 주입받아 사용하게 했습니다. 그래서.. 제 생각에 멀티쓰레드에서 문제가 생긴다면 InputPresentation 외적인 요소에서 잘못에 기인한 부분이지 않을까 싶습니다
  - Scanner 클래스의 경우.. 쓰레드 문제에서 조금 더 문제가 있어서 제 개인적인 생각에는 선택권이 있다면 BufferedReader InputStreamReader 같은 클래스를 사용하면 더 좋지 않을까? 싶습니다.
  - 이번 미션에서 굳이구태여 Scanner 를 사용할 이유가 없긴 한데요, 다만 미션페이지 힌트 부분에 소개되어있는게 Scanner 이기도 하고 편하게 쉽게 쓸수 있어서 사용하였습니다!

### 2D List(겹 리스트) 자료구조 사용의 지양
```text
public List<List<Score>> findAllScores() {
```
- 겹 리스트는 좋지 않은 것 같습니다. 대안이 없을까요?
  - 사실 이부분은 testcode 에서 반복적으로 사용되는 부분이라 메서드로 추가했는데, 로직에서는 전혀 필요없는 부분이라.. 이메서드는 삭제하겠습니다


### Step4 - 1차 리뷰사항
```text
수고 많으셨습니다. 💯
클린 코드 그 자체보다는 다양한 시도를 하시는 것에 초점이 맞춰져 있으신 것 같습니다.
제가 드렸던 의견들은 일반적인 관점에서의 클린 코드에 관한 얘기였고, 
그보다는 다양한 시도를 하시는 것을 통해 성장을 시도하시는 것 같아서, 
그런 면에서 보면 지금 코드가 나쁘지 않은 듯합니다 👍
마지막 5단계에서 마무리해주시면 좋을 것 같아요.
```

### 클래스 구조 - 도메인모델 간의 역할과 책임에 대하여 고민해보기
- Car 에 있어야 할 정보가 빠진 느낌입니다. 자신의 위치도 Car 가 알아야 하지 않나요?
- Racer 안에 승자를 구분할 수 있는 필드를 두면 이렇게 분리하지 않아도 될 거 같은데요
```text
// model/Match.java
private final List<Racer> racerList;
private final List<Racer> winnerList;
```

### 표시와 데이터의 분리
- 이걸 Car 가 관리하면 안될까요?
  - String 은 표현이고... 자기 위치는 그냥 양의 정수 형태로 보관하고 있다가, 
  - 문자열이 필요할 때 그렇게 변환하면 될 거 같은데요..
```text
public class Result {
    private final List<String> positionList;
```


### 이외
- 괄호 안에서 tab size가 8로 들어가는 것 같아서 해당 부분 수정함 : 인텔리제이 기본값에서 4로 수정
- 메소드의 정확한 기능과, public 이라는 노출 수준이 맞는지 고민필요함
- 빈 문자열의 의미없는 추출
  ```
  public class AutomobileFederation {
  private static final String INITIAL_RACING_RECODE = "";
  ```
- 만약 View 자체에 대한 테스트를 시도하신 거라면, 그 레이어에 대한 테스트는 무의미합니다. 비즈니스 로직에 대한 테스트에 집중하면 됩니다.
  ```text
  출력레이어 테스트 무의미함 (presentation 혹은 view 라는 것들) >> 순수하게 출력만 해라
  비지니스 로직 테스트에 집중하기
  ```
- static 변수의 네이밍 컨벤션(대문자)
- 함수형 인터페이스 곤란한부분
  ```text
  private static final UnaryOperator<String> validateName = name -> {
  ```
