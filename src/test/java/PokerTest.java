import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PokerTest {

    @Test
    void should_return_poker_type() {
        int[][] baoziPokerList = {{14, 1}, {14, 2}, {14, 3}};
        int[][] tonghuashunPokerList = {{14, 1}, {13, 1}, {12, 1}};
        int[][] tonghuaPokerList = {{14, 1}, {12, 1}, {10, 1}};
        int[][] shunziPokerList = {{14, 1}, {13, 2}, {12, 3}};
        int[][] duiziPokerList = {{14, 1}, {14, 2}, {10, 3}};
        int[][] danzhangPokerList = {{2, 1}, {3, 2}, {5, 3}};

        PokerType baoziPt = Poker.getType(baoziPokerList);
        PokerType tonghuashunPt = Poker.getType(tonghuashunPokerList);
        PokerType tonghuaPt = Poker.getType(tonghuaPokerList);
        PokerType shunziPt = Poker.getType(shunziPokerList);
        PokerType duiziPt = Poker.getType(duiziPokerList);
        PokerType danzhangPt = Poker.getType(danzhangPokerList);

        Assertions.assertEquals(PokerType.BAOZI, baoziPt);
        Assertions.assertEquals(PokerType.TONGHUASHUN, tonghuashunPt);
        Assertions.assertEquals(PokerType.TONGHUA, tonghuaPt);
        Assertions.assertEquals(PokerType.SHUNZI, shunziPt);
        Assertions.assertEquals(PokerType.DUIZI, duiziPt);
        Assertions.assertEquals(PokerType.DANZHANG, danzhangPt);
    }

    @Test
    void should_throw_poker_list_invalid_exception_when_give_a_invalid_poker_list() {
        int[][] invalidPokerList1 = {{14, 1}, {14, 2}, {14, 3}, {14, 3}};
        int[][] invalidPokerList2 = {{14, 1, 1}, {14, 2}, {14, 3}};
        int[][] invalidPokerList3 = {{16, 1}, {14, 2}, {14, 3}};
        int[][] invalidPokerList4 = {{0, 1}, {14, 2}, {14, 3}};
        int[][] invalidPokerList5 = {{14, 5}, {14, 2}, {14, 3}};
        int[][] invalidPokerList6 = {{14, 0}, {14, 2}, {14, 3}};
        int[][] invalidPokerList7 = null;

        Assertions.assertThrows(InvalidPokerListException.class, () -> {
            Poker.getType(invalidPokerList1);
        });
        Assertions.assertThrows(InvalidPokerListException.class, () -> {
            Poker.getType(invalidPokerList2);
        });
        Assertions.assertThrows(InvalidPokerListException.class, () -> {
            Poker.getType(invalidPokerList3);
        });
        Assertions.assertThrows(InvalidPokerListException.class, () -> {
            Poker.getType(invalidPokerList4);
        });
        Assertions.assertThrows(InvalidPokerListException.class, () -> {
            Poker.getType(invalidPokerList5);
        });
        Assertions.assertThrows(InvalidPokerListException.class, () -> {
            Poker.getType(invalidPokerList6);
        });
        Assertions.assertThrows(InvalidPokerListException.class, () -> {
            Poker.getType(invalidPokerList7);
        });
    }

    @Test
    void should_return_compare_result() {
        int[][] baoziPokerList = {{13, 1}, {13, 2}, {13, 3}};
        int[][] baoziPokerList2 = {{14, 1}, {14, 2}, {14, 3}};

        int v = Poker.compare(baoziPokerList, baoziPokerList2);

        Assertions.assertTrue(v < 0);
    }

    @Test
    void should_throw_exception_when_not_suport_compare_type() {
        int[][] pokerList = {{13, 1}, {13, 2}, {13, 3}};
        int[][] pokerList2 = {{12, 1}, {14, 2}, {14, 3}};

        Assertions.assertThrows(NotSupportCompareTypeException.class, () -> {
            Poker.compare(pokerList, pokerList2);
        });
    }


}
