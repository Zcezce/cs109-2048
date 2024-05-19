package model;

import java.util.Arrays;
import java.util.Random;

public class GridNumber {
    private final int X_COUNT;
    private final int Y_COUNT;

    private int[][] numbers;

    static Random random = new Random();

    public GridNumber(int xCount, int yCount) {
        this.X_COUNT = xCount;
        this.Y_COUNT = yCount;
        this.numbers = new int[this.X_COUNT][this.Y_COUNT];
        this.initialNumbers();
    }

    public void initialNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = 0;
            }
        }
        // Place initial tiles
        placeRandomTile();
        placeRandomTile();
    }

    private void placeRandomTile() {
        int x, y;
        do {
            x = random.nextInt(X_COUNT);
            y = random.nextInt(Y_COUNT);
        } while (numbers[x][y] != 0);
        numbers[x][y] = random.nextInt(2) == 0 ? 2 : 4;
    }

    private void move(int dx, int dy) {
        boolean moved = false;

        for (int i = 0; i < X_COUNT; i++) {
            for (int j = 0; j < Y_COUNT; j++) {
                int x = dx > 0 ? X_COUNT - 1 - i : i;
                int y = dy > 0 ? Y_COUNT - 1 - j : j;
                if (numbers[x][y] != 0) {
                    int nx = x, ny = y;
                    while (true) {
                        int nextX = nx + dx, nextY = ny + dy;
                        if (nextX < 0 || nextX >= X_COUNT || nextY < 0 || nextY >= Y_COUNT || (numbers[nextX][nextY] != 0 && numbers[nextX][nextY] != numbers[nx][ny])) {
                            break;
                        }
                        nx = nextX;
                        ny = nextY;
                    }
                    if (nx != x || ny != y) {
                        if (numbers[nx][ny] == 0) {
                            numbers[nx][ny] = numbers[x][y];
                        } else if (numbers[nx][ny] == numbers[x][y]) {
                            numbers[nx][ny] *= 2;
                        }
                        numbers[x][y] = 0;
                        moved = true;
                    }
                }
            }
        }

        if (moved) {
            placeRandomTile();
        }
    }

    public void moveRight() {
        move(0, 1);
    }

    public void moveLeft() {
        move(0, -1);
    }

    public void moveUp() {
        move(-1, 0);
    }

    public void moveDown() {
        move(1, 0);
    }

    public int getNumber(int i, int j) {
        return numbers[i][j];
    }

    public void printNumber() {
        for (int[] line : numbers) {
            System.out.println(Arrays.toString(line));
        }
    }

    public static void main(String[] args) {
        model.GridNumber grid = new model.GridNumber(4, 4);
        grid.printNumber();

        System.out.println("Moving Right");
        grid.moveRight();
        grid.printNumber();

        System.out.println("Moving Down");
        grid.moveDown();
        grid.printNumber();

        System.out.println("Moving Left");
        grid.moveLeft();
        grid.printNumber();

        System.out.println("Moving Up");
        grid.moveUp();
        grid.printNumber();
    }
}
