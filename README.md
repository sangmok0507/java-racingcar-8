# java-racingcar-precourse

---
## 기능 요구 사항
### 초간단 자동차 경주 게임 구현
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있음
- 각 자동차에 이름을 부여할 수 있으며, 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 함
- 전진하는 조건: 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려줌(공동 우승 가능)
- 공동 우승일 경우 쉼표(,)를 이용하여 구분
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료
---
## 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth는 2 이하로 구현
- 3항 연산자 사용 X
- 메서드가 한 가지 일만 하도록 최대한 작게 만들어야 함
---
## 라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 활용
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine() 활용