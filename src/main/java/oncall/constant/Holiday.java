package oncall.constant;

import java.util.Arrays;
import java.util.List;

public enum Holiday {
    HD("휴일", Arrays.asList("1월 1일","3월 1일","5월 5일","6월 6일","8월 15일","10월 3일","10월 9일","12월 25일")),
    ;

    private final String DAYS_COUNT;
    private final List<String> HOLIDAYLIST;

    Holiday(String DAYS_COUNT, List<String> HOLIDAYLIST) {
        this.DAYS_COUNT = DAYS_COUNT;
        this.HOLIDAYLIST = HOLIDAYLIST;
    }

    public String getDAYS_COUNT() {
        return DAYS_COUNT;
    }

    public List<String> getHOLIDAYLIST() {
        return HOLIDAYLIST;
    }
}
