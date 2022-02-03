import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class ArrayGenerator {

    public int[][] createArray(int outerSize) {
        if (outerSize <= 0) {
            throw new IllegalArgumentException("Size should be positive integer");
        }
        int[][] data = generateArray(outerSize);
        sortAlternate(data);
        return data;
    }

    private int[][] generateArray(int outerSize) {
        int[][] data = new int[outerSize][];
        HashSet<Integer> usedSizes = new HashSet<>(outerSize);
        Random random = new Random();
        for (int i = 0; i < outerSize; i++) {
            int defaultLimit = 50;
            int innerSize = random.nextInt(1, Math.max(defaultLimit, outerSize));
            while (usedSizes.contains(innerSize)) {
                innerSize = random.nextInt(1, Math.max(defaultLimit, outerSize));
            }
            usedSizes.add(innerSize);
            data[i] = new int[innerSize];
            for (int j = 0; j < innerSize; j++) {
                int upperLimit = 1000;
                data[i][j] = random.nextInt(upperLimit);
            }

        }
        return data;
    }

    private void sortAlternate(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            Arrays.sort(data[i]);
            if (i % 2 == 1) {
                for (int j = 0, temp, antiJ; j < data[i].length / 2; j++) {
                    antiJ = data[i].length - j - 1;
                    temp = data[i][j];
                    data[i][j] = data[i][antiJ];
                    data[i][antiJ] = temp;
                }
            }
        }
    }
}
