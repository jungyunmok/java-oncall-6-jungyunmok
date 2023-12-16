package oncall.model;

import java.util.*;

public class Exception {
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
}
