import java.util.*;

public class ArrayGenerator {
    private static int NUMBER_LIMIT = 1000;

    public Integer[][] generateArray(int outerSize) {
        if (outerSize <= 0) {
            throw new IllegalArgumentException("Size should be positive integer");
        }
        Integer[][] data = populateArray(outerSize);
        sortAlternate(data);
        return data;
    }

    private Integer[][] populateArray(int outerSize) {
        Integer[][] data = new Integer[outerSize][];
        Random random = new Random();
        List<Integer> innerSizes = new ArrayList<>(outerSize);
        for (int i = 1; i <= outerSize; i++) {
            innerSizes.add(i);
        }
        Collections.shuffle(innerSizes);
        for (int i = 0; i < outerSize; i++) {
            data[i] = new Integer[innerSizes.get(i)];
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = random.nextInt(NUMBER_LIMIT);
            }
        }
        return data;
    }

    private void sortAlternate(Integer[][] data) {
        for (int i = 0; i < data.length; i++) {
            if (i % 2 == 0) {
                Arrays.sort(data[i], Collections.reverseOrder());
            } else {
                Arrays.sort(data[i]);
            }
        }
    }
}
