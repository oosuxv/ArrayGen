import java.util.*;

public class ArrayGenerator {
    private static int ARRAY_STEP_LIMIT = 5;
    private static int NUMBER_LIMIT = 1000;

    public int[][] generateArray(int outerSize) {
        if (outerSize <= 0) {
            throw new IllegalArgumentException("Size should be positive integer");
        }
        int[][] data = populateArray(outerSize);
        sortAlternate(data);
        return data;
    }

    private int[][] populateArray(int outerSize) {
        int[][] data = new int[outerSize][];
        Random random = new Random();
        List<Integer> innerSizes = new ArrayList<>(outerSize);
        innerSizes.add(random.nextInt(1, ARRAY_STEP_LIMIT));
        for (int i = 1; i < outerSize; i++) {
            innerSizes.add(innerSizes.get(i - 1) + random.nextInt(1, ARRAY_STEP_LIMIT));
        }
        Collections.shuffle(innerSizes);
        for (int i = 0; i < outerSize; i++) {
            data[i] = new int[innerSizes.get(i)];
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = random.nextInt(NUMBER_LIMIT);
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
