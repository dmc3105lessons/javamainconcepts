package ru.dmc3105.multithreading;

public class Program {
    public static int counter = 0;
    public static Object monitor = new Object();

    public static void increment10000times() {
        for (int i = 0; i < 100000; i++) {
            synchronized (monitor) {
                counter++;
                // Будим ожидающий поток только когда достигли цели
                if (counter == 100000) {
                    monitor.notifyAll();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }

    public static void printWhenCounterIs10000() {
        synchronized (monitor) {
            // Используем while вместо if для защиты от ложных пробуждений (spurious wakeups)
            while (counter < 100000) {
                System.out.printf("no :( - %d\n", counter);
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            System.out.println("COUNTER IS 10000!!!!!!!!!!");
        }
    }

    static void main() throws InterruptedException {
        var incrementThread = new Thread(Program::increment10000times);
        var statisticsThread = new Thread(Program::printWhenCounterIs10000);

        incrementThread.start();
        statisticsThread.start();
    }
}
