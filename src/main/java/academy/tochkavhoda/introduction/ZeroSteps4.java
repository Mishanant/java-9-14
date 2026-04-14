package academy.tochkavhoda.introduction;

public class ZeroSteps4
{
    // 1. Возвращает минимальное значение в матрице или Integer.MAX_VALUE, если матрица пуста
    public int min(int[][] matrix) {
        int minVal = Integer.MAX_VALUE;
        boolean found = false;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < minVal) {
                    minVal = num;
                    found = true;
                }
            }
        }
        return found ? minVal : Integer.MAX_VALUE;
    }

    // 2. Возвращает максимальное значение в матрице или Integer.MIN_VALUE, если матрица пуста
    public int max(int[][] matrix) {
        int maxVal = Integer.MIN_VALUE;
        boolean found = false;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > maxVal) {
                    maxVal = num;
                    found = true;
                }
            }
        }
        return found ? maxVal : Integer.MIN_VALUE;
    }

    // 3. Проверяет наличие значения в матрице
    public boolean find(int[][] matrix, int value) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == value) {
                    return true;
                }
            }
        }
        return false;
    }

    // 4. Проверяет, что все строки строго убывают
    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length - 1; i++) {
                if (row[i] <= row[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 5. Подсчитывает строки, не содержащие нулевых элементов
    public int hasNoZeroRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            boolean hasZero = false;
            for (int num : row) {
                if (num == 0) {
                    hasZero = true;
                    break;
                }
            }
            if (!hasZero) {
                count++;
            }
        }
        return count;
    }

    // 6. Проверяет наличие хотя бы одной строки, состоящей только из нулей
    public boolean hasFullZeroRow(int[][] matrix) {
        for (int[] row : matrix) {
            boolean allZero = true;
            for (int num : row) {
                if (num != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero && row.length > 0) {
                return true;
            }
        }
        return false;
    }

    // 7. Проверяет симметричность матрицы относительно главной диагонали
    public boolean isSymmetric(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            if (matrix[i].length != matrix.length) {
                // Не квадратная матрица не может быть симметричной
                return false;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int a = (j < matrix[i].length) ? matrix[i][j] : 0;
                int b = (i < matrix[j].length) ? matrix[j][i] : 0;
                if (a != b) {
                    return false;
                }
            }
        }
        return true;
    }

    // 8. Максимальное значение на главной диагонали
    public int mainDiagonalMax(int[][] matrix) {
        int maxVal = Integer.MIN_VALUE;
        int len = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < len; i++) {
            if (matrix[i].length > i) {
                if (matrix[i][i] > maxVal) {
                    maxVal = matrix[i][i];
                }
            }
        }
        return (matrix.length == 0 || matrix[0].length == 0) ? Integer.MIN_VALUE : maxVal;
    }

    // 9. Сумма положительных элементов главной диагонали
    public int mainDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;
        int len = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < len; i++) {
            if (matrix[i].length > i && matrix[i][i] > 0) {
                sum += matrix[i][i];
            }
        }
        return sum;
    }

    // 10. Максимальное значение на побочной диагонали
    public int secondaryDiagonalMax(int[][] matrix) {
        int maxVal = Integer.MIN_VALUE;
        int n = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < n; i++) {
            int j = matrix[i].length - 1 - i;
            if (j >= 0 && j < matrix[i].length) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                }
            }
        }
        return (matrix.length == 0 || matrix[0].length == 0) ? Integer.MIN_VALUE : maxVal;
    }

    // 11. Сумма положительных элементов побочной диагонали
    public int secondaryDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;
        int n = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < n; i++) {
            int j = matrix[i].length - 1 - i;
            if (j >= 0 && j < matrix[i].length && matrix[i][j] > 0) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    // 12. Сумма двух матриц одинакового размера
    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        int maxRows = Math.max(matrix1.length, matrix2.length);
        int[][] result = new int[maxRows][];
        for (int i = 0; i < maxRows; i++) {
            int[] row1 = i < matrix1.length ? matrix1[i] : new int[0];
            int[] row2 = i < matrix2.length ? matrix2[i] : new int[0];
            int maxLen = Math.max(row1.length, row2.length);
            result[i] = new int[maxLen];
            for (int j = 0; j < maxLen; j++) {
                int val1 = j < row1.length ? row1[j] : 0;
                int val2 = j < row2.length ? row2[j] : 0;
                result[i][j] = val1 + val2;
            }
        }
        return result;
    }

    // 13. Транспонирование квадратной матрицы
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j < matrix[i].length && i < matrix[j].length) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    // 14. Меняет местами четные и нечетные строки
    public void interchange(int[][] matrix) {
        int rowCount = matrix.length;
        for (int i = 0; i < rowCount; i += 2) {
            int oddIndex = i + 1;
            if (oddIndex < rowCount) {
                int[] temp = matrix[i];
                matrix[i] = matrix[oddIndex];
                matrix[oddIndex] = temp;
            }
        }
    }

    // 15. Преобразование в линейный массив по строкам
    public int[] toLinearByRow(int[][] matrix) {
        int totalLength = 0;
        for (int[] row : matrix) {
            totalLength += row.length;
        }
        int[] result = new int[totalLength];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                result[index++] = num;
            }
        }
        return result;
    }

    // 16. Преобразование в линейный массив по столбцам (только для квадратных)
    public int[] toLinearByColumn(int[][] matrix) {
        int size = matrix.length;
        int totalLength = 0;
        for (int[] row : matrix) {
            totalLength += row.length;
        }
        int[] result = new int[totalLength];
        int index = 0;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (j < matrix[i].length) {
                    result[index++] = matrix[i][j];
                }
            }
        }
        return result;
    }

    // 17. Преобразование верхнего треугольника в линейный массив
    public int[] toLinearByRowUpperTriangle(int[][] matrix) {
        int size = matrix.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            count += (matrix[i].length >= i + 1) ? (matrix[i].length - i) : 0;
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            int limit = Math.min(matrix[i].length, size);
            for (int j = i; j < limit; j++) {
                result[index++] = matrix[i][j];
            }
        }
        return result;
    }

    // 18. Сумма элементов до появления barrier в каждой строке
    public int sumUntilNotFoundInRow(int[][] matrix, int barrier) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == barrier) {
                    break;
                }
                sum += num;
            }
        }
        return sum;
    }

    // 19. Общая сумма элементов до появления barrier во всей матрице
    public int sumUntilNotFound(int[][] matrix, int barrier) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == barrier) {
                    return sum;
                }
                sum += num;
            }
        }
        return sum;
    }
}
