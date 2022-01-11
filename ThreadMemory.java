

public class ThreadMemory extends Thread {
    private final Memory memory;
    private final Integer positionVirtualMemory;
    private final String valueOperation;
    private String nameThread;

    public ThreadMemory(String name, Memory memory, Integer positionVirtualMemory, String valueOp) {
        this.memory = memory;
        this.positionVirtualMemory = positionVirtualMemory;
        this.valueOperation = valueOp;
        this.nameThread = name;
    }

    public void run() {
        try {
            synchronized (memory) {
                System.out.println(nameThread + " [Lock Received]");
                if (memory.checkOperation(valueOperation)) {
                    System.out.print(nameThread + " [READ] ");
                    memory.read(positionVirtualMemory);
                } else {
                    System.out.print(nameThread + " [WRITE] ");
                    memory.write(positionVirtualMemory, valueOperation);
                    sleep(2000);
                }
                System.out.println(nameThread + " [PRE NotifyAll]");
                memory.notifyAll();
                System.out.println(nameThread + " [POS NotifyAll]");
                System.out.println(nameThread + " [PRE Wait - Lock Free]");
                memory.wait();
//                System.out.println(nameThread + " [Received NotifyAll]");
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}

