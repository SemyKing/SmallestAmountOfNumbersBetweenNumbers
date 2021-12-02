import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test1() {
        int[] array = {1, 4, 10};
        Integer response = Main.getSmallestAmountOfNumbersFromTests(array);

        Assertions.assertEquals(2, response);
    }

    @Test
    void test2() {
        int[] array = {1, 10, 4};
        Integer response = Main.getSmallestAmountOfNumbersFromTests(array);

        Assertions.assertEquals(2, response);
    }

    @Test
    void test3() {
        int[] array = {4, 1, 10};
        Integer response = Main.getSmallestAmountOfNumbersFromTests(array);

        Assertions.assertEquals(2, response);
    }

    @Test
    void test4() {
        int[] array = {1, 3, 5};
        Integer response = Main.getSmallestAmountOfNumbersFromTests(array);

        Assertions.assertEquals(1, response);
    }

    @Test
    void test5() {
        int[] array = {1, 2, 3};
        Integer response = Main.getSmallestAmountOfNumbersFromTests(array);

        Assertions.assertEquals(0, response);
    }

    @Test
    void test6() {
        int[] array = {1, 1, 1};
        Integer response = Main.getSmallestAmountOfNumbersFromTests(array);

        Assertions.assertNull(response);
    }

    @Test
    void test7() {
        int[] array = {1, 1, 1, 5};
        Integer response = Main.getSmallestAmountOfNumbersFromTests(array);

        Assertions.assertEquals(3, response);
    }

    @Test
    void test8() {
        int[] array = {1, 10};
        Integer response = Main.getSmallestAmountOfNumbersFromTests(array);

        Assertions.assertNull(response);
    }

    @Test
    void test9() {
        int[] array = {10};
        Integer response = Main.getSmallestAmountOfNumbersFromTests(array);

        Assertions.assertNull(response);
    }

    @Test
    void test10() {
        Integer response = Main.getSmallestAmountOfNumbersFromTests(null);

        Assertions.assertNull(response);
    }
}