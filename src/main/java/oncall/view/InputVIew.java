package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputVIew {
    // 배정할 월과 시작 요일 받기
    public String readMonthDay() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = Console.readLine();
        return input;
    }

    // 평일 근무 사원 입력받기
    public String readWeekday() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String input = Console.readLine();
        return input;
    }

    // 휴일 근무 사원 입력받기
    public String readWeekend() {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String input = Console.readLine();
        return input;
    }
}
