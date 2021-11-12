public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void isEmptyTest() {
        System.out.println("Running isEmpty test");
        ArrayDeque<Integer> intarr1 = new ArrayDeque<>();
        boolean passed = checkEmpty(true, intarr1.isEmpty());

        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> intarr2 = new ArrayDeque<>();
        // should be empty
        boolean passed = checkEmpty(true, intarr2.isEmpty());

        intarr2.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, intarr2.isEmpty()) && passed;

        intarr2.addFirst(9);
        intarr2.addLast(11);
        intarr2.printDeque();
		intarr2.removeLast();
		intarr2.printDeque();
        intarr2.removeFirst();
        intarr2.printDeque();
        System.out.println(intarr2.get(0));
        System.out.println(intarr2.get(1));
        System.out.println(intarr2.size());


/*		lld1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;*/

        printTestStatus(passed);

        intarr2.addLast(11);
        intarr2.addLast(12);
        intarr2.addLast(13);
        intarr2.addLast(14);
        intarr2.addLast(15);
        intarr2.addLast(16);
        intarr2.addLast(17);
        intarr2.addLast(18);
        intarr2.addLast(19);
        intarr2.printDeque();
        intarr2.printLength();
        for (int i = 0; i < 6; i += 1){
            intarr2.removeFirst();
        }
        intarr2.printLength();

    }

    public static void main(String args[]) {
        System.out.println("Running tests.\n");
        isEmptyTest();
        addRemoveTest();

    }
}
