

public class Main {

    public static void main(String[] args) {
        Memory memory = new Memory(4);

        Integer listPositionA[] = { 2,   5,   3,   7,   6,   1,   0,   4,   3,   7,   6,};
        String listOperationA[] = {"6", "2", "0", "8", "R", "4", "2", "0", "8", "R", "4"};

        Integer listPositionC[] = { 6,   7,   3,   4,   0,   1,   6,   7,   3,   5,   2};
        String listOperationC[] = {"7", "1", "8", "1", "0", "R", "5", "R", "2", "6", "3"};

        Integer listPositionB[] = { 1,   2,   3,   5,   4,   7,   1,   1,   6,   7,   3};
        String listOperationB[] = {"1", "8", "R", "8", "4", "3", "0", "R", "9", "R", "2"};

        for (int i = 0; i < listPositionA.length; i++) {
            new ThreadMemory("Thread A", memory, listPositionA[i], listOperationA[i]).start();
            new ThreadMemory("Thread B", memory, listPositionB[i], listOperationB[i]).start();
            new ThreadMemory("Thread C", memory, listPositionC[i], listOperationC[i]).start();
        }
    }


}
