import java.util.*;

public class NumeroDos {

    public static class CustomThread extends Thread {
        private int[] nums;
        private int max;
        private Map<Integer, Integer> answers;
        private int rowIndex;

        public CustomThread(int[] nums, Map<Integer, Integer> answers, int rowIndex) {
            this.nums = nums;
            this.answers = answers;
            this.rowIndex = rowIndex;
        }

        public void run() {
            for (int num : nums) {
                max = Math.max(max, num);
            }
            answers.put(rowIndex, max);
        }
    }

    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        Map<Integer, Integer> answers = Collections.synchronizedMap(new HashMap<>());

        List<CustomThread> threads = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            CustomThread thread = new CustomThread(matrix[i], answers, i);
            threads.add(thread);
            thread.start();
        }

        for (CustomThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int maxElement = answers.values().stream().max(Integer::compareTo).orElseThrow();

        System.out.println("Maximum element in matrix: " + maxElement);
    }
}
