## 피드백 내용 정리

[ 1차 ]  
전체적인 설계와 깔끔한 코드 구현이 좋았습니다. 👍  
고민해보면 좋을 것 같은 의견을 남겨놓았으니 충분히 고민하고 도전해보세요!  
원활한 2단계 진행을 위해 1단계는 빠르게 Merge 할게요.  


### src/test/java/study/SetTest2.java
프로그래밍을 하다 보면 다음과 같은 느낌이 들어 코드를 삭제하지 않고 주석 처리하는 경우가 있는데요.  
- 이 코드가 지금은 사용하지 않지만 언젠가 사용할 수 있을 것 같다.  
- 이 코드를 내가 정말 힘들게 구현해서 삭제하기 아깝다.  
- 분명 사용하지 않는 코드로 파악되지만 내가 구현한 코드가 아니라 함부로 삭제하기 힘들다.  
- 과거에는 Subversion과 Git 같은 형상관리 툴을 사용하지 않았고, 코드를 참고할만한 곳이 많지 않았기 때문에 주석을 통해 유지하는 것이 의미가 있었을 거예요. 하지만 최근 개발 환경은 형상관리 툴을 사용하는 것이 일반적이 되어 이전에 구현한 코드를 손쉽게 원복 할 수 있게 되었어요. 오히려 지금은 코드를 얼마나 깔끔하고 가독성이 좋은 코드로 유지하는지가 더 중요하지 않을까요? 현시점에 굳이 필요 없다고 생각하는 코드가 있다면 아까운 마음을 버리고 가차 없이 삭제해보세요.  

==> 네 확인했습니다. 형상관리 툴을 이용해 이력을 확인할 수 있기에 해당 로직은 삭제했습니다.

### src/main/java/edu/nextstep/stepone/CalculatorApplication.java
상수 이름은 모두 'CONSTANT_CASE`를 사용합니다. 아래의 Google Java Style Guide를 참고해주세요.
- https://google.github.io/styleguide/javaguide.html#s5.2.4-constant-names

==> firstIndex => FIRST_INDEX / lastIndex => LAST_INDEX 로 수정 했습니다.

### src/main/java/edu/nextstep/stepone/Validation.java
상수는 static final 필드입니다. 아래의 코드로 개선해보면 어떨까요?
```java
private static final String SEPARATOR_SPLIT = " ";
```

==> 접근제어자 static을 붙여 상수화 했습니다.

### src/main/java/edu/nextstep/stepone/Validation.java
만약 inputData가 null이라면 어떤 위험이 발생할까요? 그 위험을 피할 수 있는 방법도 찾아보면 좋을 것 같아요. 아래의 글이 도움 될 거예요.
- https://www.jpstory.net/2014/02/09/avoid-nullpointerexception

==> 
아래의 equals 사용의 차이를 숙지했습니다.
```java
// AS-IS
if(inputData.trim().equals("") || inputData == null) 
// TO-BE
if("".equals(inputData.trim()) || inputData == null)
```

### src/main/java/edu/nextstep/stepone/Validation.java
메서드 이름은 isBlank가 아닌 isNotBlank가 적절해 보여요.

==> return 값의 기대값을 확인하여 method name 수정하였습니다.

### src/main/java/edu/nextstep/stepone/Operator.java
Operator는 OperatorType과 합칠 수 있을까요?

==> Enum에 lambda를 적용하면 가능할 것으로 보입니다. 이 부분은 좀더 학습을 한뒤에 수정하여 리뷰요청을 드려보겠습니다.

### src/main/java/edu/nextstep/stepone/Validation.java
현재 Validation은 입력된 값의 유효성을 검사하는 기능과 문자를 숫자로 변환하는 기능을 하고 있어요. 단일 책임 원칙(single responsibility principle)이라는 것을 찾아보고 아래의 질문에 답해보면 좋을 것 같아요.

- 객체 지향 프로그래밍에서 단일 책임 원칙(single responsibility principle)이란 무엇일까요?  
==> 각각의 함수, 클래스 및 컴포넌트는 한가지의 기능만 수행하도록 개발하는 것
    
- 그것을 하는 이유는 무엇일까요?  
==> 개인적인 생각으로는 클래스의 명만 봐도 내부 메서드들이 어떠한 수행을 하겠다는 의미가 보일 것으로 생각됩니다. 하지만 1차 구현한 소스에서는 그러한 의미를 파악하기 어려운 convert 메서드가 있어 분리가 필요할 것으로 보입니다.  

- 단일 책임 원칙을 Validation에는 어떻게 적용할 수 있을까요?  
==> StringUtils.class를 생성하여 convert메서드를 분리하였습니다. 

### src/main/java/edu/nextstep/stepone/Validation.java
IntelliJ IDEA의 코드 자동 정렬 기능(⌥⌘L, Ctrl+Alt+L)을 사용하면 더 깔끔한 코드를 볼 수 있을 거예요.
