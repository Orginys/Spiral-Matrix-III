class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // Массив, задающий направления движения: вправо, вниз, влево, вверх
        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        // Создаем массив для хранения результата, размерностью rows * cols
        int[][] result = new int[rows * cols][2];
        // Индекс для записи в массив result
        int index = 0;
        // Начальное количество шагов, которое мы будем делать в каждом направлении
        int steps = 1;
        // Текущие направление (0 - вправо, 1 - вниз, 2 - влево, 3 - вверх)
        int d = 0;
        // Начальные координаты
        int r = rStart, c = cStart;
        // Записываем стартовые координаты в результат
        result[index++] = new int[] { r, c };

        // Продолжаем, пока не заполним весь результат
        while (index < rows * cols) {
            // Проходим по каждому направлению дважды (так как движение увеличивается с каждым полным кругом)
            for (int i = 0; i < 2; i++) {
                // Делаем определенное количество шагов в текущем направлении
                for (int j = 0; j < steps; j++) {
                    // Двигаемся в текущем направлении
                    r += directions[d][0];
                    c += directions[d][1];
                    // Проверяем, находится ли текущая клетка в пределах матрицы
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        // Если да, добавляем её в результат
                        result[index++] = new int[] { r, c };
                    }
                }
                // Переходим к следующему направлению (по часовой стрелке)
                d = (d + 1) % 4;
            }
            // Увеличиваем количество шагов после прохождения каждого полного круга
            steps++;
        }
        // Возвращаем массив с координатами
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Пример 1: Тестируем метод с параметрами 1x4 матрица, начальная позиция (0,0)
        int[][] result1 = solution.spiralMatrixIII(1, 4, 0, 0);
        // Печатаем результат
        for (int[] cell : result1) {
            System.out.println("[" + cell[0] + "," + cell[1] + "]");
        }
        System.out.println();

        // Пример 2: Тестируем метод с параметрами 5x6 матрица, начальная позиция (1,4)
        int[][] result2 = solution.spiralMatrixIII(5, 6, 1, 4);
        // Печатаем результат
        for (int[] cell : result2) {
            System.out.println("[" + cell[0] + "," + cell[1] + "]");
        }
        System.out.println();
    }
}