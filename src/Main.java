public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

        Thread sumThread = new Thread(new SumTask(numbers));
        Thread maxThread = new Thread(new MaxTask(numbers));

        sumThread.start();
        maxThread.start();
    }
}

class SumTask implements Runnable {
    private int[] numbers;
    public SumTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Tổng của các phần tử trong mảng: " + sum);
    }
}

class MaxTask implements Runnable {
    private int[] numbers;

    public MaxTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng: " + max);
    }
}
