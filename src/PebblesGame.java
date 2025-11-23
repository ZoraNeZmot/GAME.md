import java.util.Scanner;

public class PebblesGame {

    /**
     * Проверяет, является ли позиция выигрышной для текущего игрока
     * @param n количество камней в кучке
     * @return true если позиция выигрышная, false если проигрышная
     */
    public static boolean isWinningPosition(int n) {
        return n % 4 != 0;
    }

    /**
     * Находит выигрышный ход из текущей позиции
     * @param n текущее количество камней
     * @return количество камней, которое нужно взять для выигрышного хода, или -1 если нет выигрышного хода
     */
    public static int findWinningMove(int n) {
        if (n % 4 == 0) {
            return -1; // Проигрышная позиция, нет выигрышного хода
        }
        return n % 4; // Берем столько камней, чтобы оставить противнику число, кратное 4
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читаем количество камней из консоли
        int n = scanner.nextInt();

        // Вычисляем результаты
        boolean isWinning = isWinningPosition(n);
        int move = findWinningMove(n);

        // Выводим результаты в требуемом формате
        System.out.println(n);
        System.out.println(isWinning);
        System.out.println(move);

        scanner.close();
    }
}