package academy.tochkavhoda.introduction;

public class ZeroSteps3 {

    // Возвращает сумму элементов массива, или 0 для пустого массива
    public int sum(int[] array) {
        int total = 0;
        for (int num : array) {
            total += num;
        }
        return total;
    }

    // Возвращает произведение элементов массива, или 0 для пустого массива
    public int mul(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int product = 1;
        for (int num : array) {
            product *= num;
        }
        return product;
    }

    // Возвращает минимальное значение в массиве, или Integer.MAX_VALUE для пустого массива
    public int min(int[] array) {
        if (array.length == 0) {
            return Integer.MAX_VALUE;
        }
        int minValue = array[0];
        for (int num : array) {
            if (num < minValue) {
                minValue = num;
            }
        }
        return minValue;
    }

    // Возвращает максимальное значение в массиве, или Integer.MIN_VALUE для пустого массива
    public int max(int[] array) {
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int maxValue = array[0];
        for (int num : array) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue;
    }

    // Возвращает среднее значение элементов массива, или 0 для пустого массива
    public double average(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int sum = sum(array);
        return (double) sum / array.length;
    }

    // 6. Проверка, упорядочен ли массив по убыванию (строгое)
    public boolean isSortedDescendant(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // 7. Возводит все элементы массива в куб
    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    // 8. Проверяет, есть ли в массиве элемент, равный value
    public boolean find(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    // 9. Переворачивает массив
    public void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    // 10. Проверяет, является ли массив палиндромом
    public boolean isPalindrome(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 11. Заменяет элементы массива на их квадраты, пока не встретится нулевой элемент
    public void replaceBySquare(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                break;
            }
            array[i] = array[i] * array[i];
        }
    }

    // 12. Возвращает произведение ненулевых чисел массива, или 0 для пустого массива
    public int mulNonZero(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int product = 1;
        boolean hasNonZero = false;
        for (int num : array) {
            if (num != 0) {
                product *= num;
                hasNonZero = true;
            }
        }
        return hasNonZero ? product : 0;
    }

    // 13. Проверяет, все ли элементы массива положительные, для пустого массива возвращает false
    public boolean allPositive(int[] array) {
        if (array.length == 0) {
            return false;
        }
        for (int num : array) {
            if (num <= 0) {
                return false;
            }
        }
        return true;
    }

    // 14. Проверяет, все ли элементы массива равны между собой, для пустого массива возвращает true
    public boolean allEqual(int[] array) {
        if (array.length == 0) {
            return true;
        }
        int first = array[0];
        for (int num : array) {
            if (num != first) {
                return false;
            }
        }
        return true;
    }

    // 15. Возвращает индекс первого элемента, который больше своих соседей, исключая первый и последний
    public int greaterThanNeighbours(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // 16. Определяет, есть ли элемент, равный полусумме своих соседей
    public boolean neighboursAverage(double[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] == (array[i - 1] + array[i + 1]) / 2) {
                return true;
            }
        }
        return false;
    }

    // 17. Возвращает сумму элементов между двумя нулями, предполагается, что их ровно 2
    public int sumBetween2Zeros(int[] array) {
        int firstZeroIndex = -1;
        int secondZeroIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (firstZeroIndex == -1) {
                    firstZeroIndex = i;
                } else {
                    secondZeroIndex = i;
                    break;
                }
            }
        }
        if (firstZeroIndex == -1 || secondZeroIndex == -1 || secondZeroIndex <= firstZeroIndex) {
            return 0;
        }
        int sum = 0;
        for (int i = firstZeroIndex + 1; i < secondZeroIndex; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Возвращает количество элементов, для которых совпадают значения в одной и той же позиции в обоих массивах.
     * Массивы могут иметь разную длину.
     *
     * @param array1 Первый массив
     * @param array2 Второй массив
     * @return Количество совпадающих элементов на одинаковых позициях
     */
    public int sameAtPosition(int[] array1, int[] array2) {
        int count = 0;
        int minLength = Math.min(array1.length, array2.length);
        for (int i = 0; i < minLength; i++) {
            if (array1[i] == array2[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Возвращает true, если есть хотя бы одна позиция, для которой элементы в обоих массивах равны нулю.
     * Массивы могут иметь разную длину.
     *
     * @param array1 Первый массив
     * @param array2 Второй массив
     * @return true, если есть хотя бы одна позиция с нулевыми элементами в обоих массивах
     */
    public boolean bothZeroAtPosition(int[] array1, int[] array2) {
        int minLength = Math.min(array1.length, array2.length);
        for (int i = 0; i < minLength; i++) {
            if (array1[i] == 0 && array2[i] == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Заменяет все элементы массива array по правилу: i-й элемент становится равен сумме элементов с 0 по i.
     *
     * @param array Массив, который нужно модифицировать
     */
    public void accumulatedSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            array[i] = sum;
        }
    }

    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        // Слияние двух отсортированных массивов
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        // Добавляем оставшиеся элементы из array1
        while (i < array1.length) {
            result[k++] = array1[i++];
        }

        // Добавляем оставшиеся элементы из array2
        while (j < array2.length) {
            result[k++] = array2[j++];
        }

        return result;
    }

    /**
     * Подсчитывает количество точек, попадающих в круг радиуса radius с центром в (0,0).
     * Точки, лежащие на окружности, считаются попавшими в круг.
     *
     * @param x массив x-координат точек
     * @param y массив y-координат точек
     * @param radius радиус круга
     * @return количество точек внутри или на границе круга
     */
    public int insideCircle(int[] x, int[] y, int radius) {
        int count = 0;
        int radiusSquared = radius * radius;

        for (int i = 0; i < x.length; i++) {
            int distanceSquared = x[i] * x[i] + y[i] * y[i];
            if (distanceSquared <= radiusSquared) {
                count++;
            }
        }

        return count;
    }

    /**
     * Вычисляет скалярное произведение двух массивов одинаковой длины.
     *
     * @param array1 первый массив
     * @param array2 второй массив
     * @return скалярное произведение
     */
    public double scalarProduct(double[] array1, double[] array2) {
        double sum = 0.0;
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i] * array2[i];
        }
        return sum;
    }
}
