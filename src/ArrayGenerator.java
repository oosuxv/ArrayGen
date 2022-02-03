import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class ArrayGenerator {

    public int[][] createArray(int outerSize) {
        if (outerSize <= 0) {
            throw new IllegalArgumentException("Size should be positive integer");
        }
        int[][] data = new int[outerSize][];
        HashSet<Integer> usedSizes = new HashSet<>(outerSize);
        Random random = new Random();
        for (int i = 0; i < outerSize; i++) {
            int maxSize = 20;
            int innerSize = random.nextInt(1, Math.max(maxSize, outerSize));
            while (usedSizes.contains(innerSize)) {
                innerSize = random.nextInt(1, Math.max(maxSize, outerSize));
            }
            usedSizes.add(innerSize);
            data[i] = new int[innerSize];
            for (int j = 0; j < innerSize; j++) {
                int upperLimit = 1000;
                data[i][j] = random.nextInt(upperLimit);
            }
            Arrays.sort(data[i]);
            if (i % 2 == 1) {
                for (int j = 0, temp; j < innerSize / 2; j++) {
                    temp = data[i][j];
                    data[i][j] = data[i][innerSize - j - 1];
                    data[i][innerSize - j - 1] = temp;
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        ArrayGenerator ag = new ArrayGenerator();
        int[][] data = ag.createArray(15);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (j != 0) {
                    System.out.print(' ');
                }
                System.out.printf("%3d", data[i][j]);
            }
            if (i != data.length - 1) {
                System.out.println();
            }
        }
    }
}
