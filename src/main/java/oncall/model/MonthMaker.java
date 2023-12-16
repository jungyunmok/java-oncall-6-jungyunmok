package oncall.model;

import oncall.constant.Month;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonthMaker {
    // 받은 월과 시작요일로 달력 만들기
    public List<String> returnMonth(Map<Integer, String> startInfo) {
        int startMonth = 0;
        String startDay = "";
        for(Integer key : startInfo.keySet()) {
            startMonth = key;
            startDay = startInfo.get(key);
        }
        int dayCount = returnDayCount(startMonth);

        List<String> monthInfo = makeMonth(dayCount, startMonth, startDay);
        return monthInfo;
    }

    // 해당 월에 맞는 일수 반환
    private int returnDayCount(int startMonth) {
        List<String> monthInfo = new ArrayList<>();
        int dayCount = 0;
        for(Month month : Month.values()) {
            if(month.getMONTHLIST().contains(startMonth)) {
                dayCount = month.getDAYS_COUNT();
            }
        }
        return dayCount;
    }

}
