### 문자열 덧셈 계산기 TODO LIST
* [x] null 또는 "" → 0 (null은 요구사항에 없어 직접 정한 규칙)
* [x] 쉼표로 구분된 숫자의 합을 반환한다 ("1,2" → 3)
* [x] 숫자 하나만 입력하면 그 숫자를 반환한다 ("1" → 1)
* [x] 쉼표 또는 콜론으로 구분된 숫자의 합을 반환한다 ("1,2:3" → 6)
* [x] "//"와 "\n" 사이의 커스텀 구분자로 구분된 숫자의 합을 반환한다 ("//;\n1;2;3" → 6)
* [x] 음수가 포함되면 RuntimeException ("-1,2")
* [x] 숫자 이외의 값이 포함되면 RuntimeException ("a,1")


### 리팩토링 TODO LIST

#### PositiveNumber
* [x] "3"으로 생성하면 값이 3이다 ("3" → 3)
* [x] "0"도 허용한다 ("0" → 0)
* [x] 음수이면 RuntimeException ("-1")
* [x] 숫자 이외의 값이면 RuntimeException ("a")
* [x] int로 생성하면 그 값과 같다 (3 → 3)
* [x] int로 생성해도 음수이면 RuntimeException (-1)
* [x] plus하면 두 값의 합과 같다 (3 + 4 → 7)

#### 리뷰 피드백 반영하여 객체지향적 리팩토링 TODO LIST
* [x] 값을 꺼내지 않고 객체에 메시지를 보낸다 (parseAndSum에서 plus 사용)
* [x] 추가: 불변 객체로 만든다 (plus는 새 객체를 반환)
* [x] 추가: 생성은 정적 팩토리 valueOf로 한다 (생성자는 private)