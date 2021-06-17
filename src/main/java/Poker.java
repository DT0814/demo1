import java.util.Arrays;
import java.util.Comparator;

public class Poker {
    public static PokerType getType(int[][] pokerList) {
        if (!checkIfIsValid(pokerList)) {
            throw new InvalidPokerListException();
        }
        Arrays.sort(pokerList, Comparator.comparingInt(a -> a[0]));

        if (checkIsIfBaoZi(pokerList)) {
            return PokerType.BAOZI;
        }

        if (checkIsIfTongHuaShun(pokerList)) {
            return PokerType.TONGHUASHUN;
        }
        if (checkIsIfTongHua(pokerList)) {
            return PokerType.TONGHUA;
        }

        if (checkIsIfShunZi(pokerList)) {
            return PokerType.SHUNZI;
        }

        if (checkIsIfDuiZi(pokerList)) {
            return PokerType.DUIZI;
        }

        return PokerType.DANZHANG;
    }

    private static boolean checkIfIsValid(int[][] pokerList) {
        if (null == pokerList) {
            return false;
        }
        if (pokerList.length != 3) {
            return false;
        }

        for (int[] ints : pokerList) {
            if (null == ints || ints.length != 2 || ints[0] > 14 || ints[0] < 1 || ints[1] < 1 || ints[1] > 4) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIsIfDuiZi(int[][] pokerList) {
        return pokerList[0][0] == pokerList[1][0]
                || pokerList[1][0] == pokerList[2][0];
    }

    private static boolean checkIsIfShunZi(int[][] pokerList) {
        return pokerList[0][0] + 1 == pokerList[1][0]
                && pokerList[1][0] + 1 == pokerList[2][0];
    }

    private static boolean checkIsIfTongHua(int[][] pokerList) {
        return checkEquals(pokerList[0][1], pokerList[1][1], pokerList[2][1]);
    }

    private static boolean checkIsIfTongHuaShun(int[][] pokerList) {
        return (pokerList[0][0] + 1) % 15 == pokerList[1][0]
                && (pokerList[1][0] + 1) % 15 == pokerList[2][0]
                && checkEquals(pokerList[0][1], pokerList[1][1], pokerList[2][1]);
    }

    private static boolean checkIsIfBaoZi(int[][] pokerList) {
        return checkEquals(pokerList[0][0], pokerList[1][0], pokerList[2][0]);
    }

    private static boolean checkEquals(int... arg) {
        if (arg.length <= 1) return true;
        int v = arg[0];
        for (int value : arg) {
            if (value != v) return false;
        }
        return true;
    }

    public static int compare(int[][] pokerList, int[][] pokerList2) {
        PokerType type = getType(pokerList);
        PokerType type2 = getType(pokerList2);

        if (type == PokerType.BAOZI && type2 == PokerType.BAOZI) {
            return pokerList[0][0] - pokerList2[0][0];
        }
        throw new NotSupportCompareTypeException();
    }
}
