package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gptframe extends JFrame implements KeyListener {
    private static final int GRID_SIZE = 4;
    private static final int TILE_SIZE = 100;
    private int[][] grid;

    public gptframe() {
        grid = new int[GRID_SIZE][GRID_SIZE];
        initializeGrid();
        setPreferredSize(new Dimension(GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("2048 Game");
        addKeyListener(this);
        setFocusable(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeGrid() {
        // Initialize the grid with zeros
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = 0;
            }
        }
        // Add initial tiles (for demonstration purpose)
        addTile();
        addTile();
    }

    private void addTile() {
        // Adds a tile (randomly 2 or 4) to a random empty cell
        // For simplicity, this method adds a tile with value 2
        int emptyCells = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == 0) {
                    emptyCells++;
                }
            }
        }
        if (emptyCells == 0) {
            return;
        }
        int position = (int) (Math.random() * emptyCells) + 1;
        emptyCells = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == 0) {
                    emptyCells++;
                    if (emptyCells == position) {
                        grid[i][j] = 2; // Add tile with value 2
                        return;
                    }
                }
            }
        }
    }

    private void moveTiles(Direction direction) {
        // Move tiles in the specified direction (LEFT, RIGHT, UP, DOWN)
        // For simplicity, this method just adds a new tile after every move
        // You need to implement the actual tile movement logic
        addTile();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key presses for tile movement
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            moveTiles(Direction.LEFT);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            moveTiles(Direction.RIGHT);
        } else if (keyCode == KeyEvent.VK_UP) {
            moveTiles(Direction.UP);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            moveTiles(Direction.DOWN);
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                int value = grid[i][j];
                int x = j * TILE_SIZE;
                int y = i * TILE_SIZE;
                g.setColor(getTileColor(value));
                g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, TILE_SIZE, TILE_SIZE);
                if (value != 0) {
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(value), x + TILE_SIZE / 2 - 10, y + TILE_SIZE / 2 + 5);
                }
            }
        }
    }

    private Color getTileColor(int value) {
        // Define colors for different tile values
        switch (value) {
            case 2:
                return new Color(238, 228, 218);
            case 4:
                return new Color(237, 224, 200);
            case 8:
                return new Color(242, 177, 121);
            case 16:
                return new Color(245, 149, 99);
            case 32:
                return new Color(246, 124, 95);
            case 64:
                return new Color(246, 94, 59);
            case 128:
                return new Color(237, 207, 114);
            case 256:
                return new Color(237, 204, 97);
            case 512:
                return new Color(237, 200, 80);
            case 1024:
                return new Color(237, 197, 63);
            case 2048:
                return new Color(237, 194, 46);
            default:
                return Color.WHITE;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(gptframe::new);
    }

    private enum Direction {
        LEFT, RIGHT, UP, DOWN
    }
}