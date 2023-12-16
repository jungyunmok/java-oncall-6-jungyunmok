package oncall.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Judgement {
    // 배정 월과 시작 요일 담아서 반환
    public Map<Integer, String> checkMonthDay(String monthDay) {
        String[] tempStr = monthArrayException(monthDay);
        if(tempStr.length > 2) {
            System.out.println("[ERROR] 배정할 월과 시작 요일을 '1,금' 형식과 같이 공백없이 쉼표로 구분하여 입력해주세요.");
            throw new IllegalArgumentException();
        }
        int startMonth = checkInt(tempStr[0]);
        String startDay = tempStr[1];
        Map<Integer, String> startInfo = new HashMap<>();
        startInfo.put(startMonth, startDay);
        return startInfo;
    }

    // 월과 요일 배열 예외처리
    private String[] monthArrayException(String monthDay) {
        String[] tempStr;
        try {
            String tempLast = String.valueOf(monthDay.charAt(monthDay.length() - 1));
            if(tempLast.equals(",")) {
                throw new ArrayIndexOutOfBoundsException();
            }
            tempStr = monthDay.split(",");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[ERROR] 배정할 월과 시작 요일을 '1,금' 형식과 같이 공백없이 쉼표로 구분하여 입력해주세요.");
            throw new IllegalArgumentException(e);
        }
        return tempStr;
    }


    // 문자열 인트 변환
    private int checkInt(String strNumber) {
        int number = 0;
        try {
            if(strNumber.equals("")) {
                throw new NumberFormatException();
            }
            number = Integer.parseInt(strNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return number;
    }

    // 근무자 이름 담아서 반환
    public List<String> checkWorker(String names) {
        List<String> workerList = new ArrayList<>();
        if(names.length() < 5 || !names.contains(",")) {
            System.out.println("[ERROR] 사원 닉네임은 쉼표로 구분하여 최소 5명, 최대 35명 입력해주세요.");
            throw new IllegalArgumentException();
        }
        String[] tempList = workerArrayException(names);
        if(tempList.length < 5 || tempList.length > 35) {
            System.out.println("[ERROR] 사원 닉네임은 쉼표로 구분하여 최소 5명, 최대 35명 입력해주세요.");
            throw new IllegalArgumentException();
        }

        return workerList;
    }

    // 근무자 배열 예외처리
    private String[] workerArrayException(String names) {
        String[] tempStr;
        try {
            String tempLast = String.valueOf(names.charAt(names.length() - 1));
            if(tempLast.equals(",")) {
                throw new ArrayIndexOutOfBoundsException();
            }
            tempStr = names.split(",");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[ERROR] 사원 닉네임은 쉼표로 구분하여 최소 5명, 최대 35명 입력해주세요.");
            throw new IllegalArgumentException(e);
        }
        return tempStr;
    }
}
