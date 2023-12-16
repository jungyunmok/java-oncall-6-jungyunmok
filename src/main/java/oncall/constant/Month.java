package oncall.constant;

import java.util.Arrays;
import java.util.List;

public enum Month {
    M31(31, Arrays.asList(1, 3, 5, 7, 8, 10, 12)),
    M30(30, Arrays.asList(4, 6, 9, 11)),
    M28(28, Arrays.asList(2));

    private final int DAYS_COUNT;
    private final List<Integer> MONTHLIST;

    Month(int DAYS_COUNT, List<Integer> MONTHLIST) {
        this.DAYS_COUNT = DAYS_COUNT;
        this.MONTHLIST = MONTHLIST;
    }

    public int getDAYS_COUNT() {
        return DAYS_COUNT;
    }

    public List<Integer> getMONTHLIST() {
        return MONTHLIST;
    }
}
