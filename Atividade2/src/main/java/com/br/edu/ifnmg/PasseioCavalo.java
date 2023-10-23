package com.br.edu.ifnmg;

public class PasseioCavalo {
    private static final int SIZE = 8;
    private static final int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    private int[][] board = new int[SIZE][SIZE];

    public PasseioCavalo(int startRow, int startColumn) {
        moveKnight(startRow, startColumn);
    }

    public void moveKnight(int currentRow, int currentColumn) {
        int moveNumber = 0;
        int totalCount = 1;
        board[currentRow][currentColumn] = totalCount;

        while (totalCount < SIZE * SIZE) {
            int nextRow, nextColumn;

            int minAccessibles = 9;
            int minMove = -1;

            for (int i = 0; i < 8; i++) {
                nextRow = currentRow + vertical[i];
                nextColumn = currentColumn + horizontal[i];

                if (isSafe(nextRow, nextColumn) && board[nextRow][nextColumn] == 0) {
                    int accessibles = countAccessibles(nextRow, nextColumn);
                    if (accessibles < minAccessibles) {
                        minAccessibles = accessibles;
                        minMove = i;
                    }
                }
            }

            if (minMove == -1) {
                break;
            } else {
                currentRow += vertical[minMove];
                currentColumn += horizontal[minMove];
                totalCount++;
                board[currentRow][currentColumn] = totalCount;
            }
        }

        printBoard();
    }

    private boolean isSafe(int row, int column) {
        return (row >= 0 && row < SIZE && column >= 0 && column < SIZE);
    }

    private int countAccessibles(int row, int column) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nextRow = row + vertical[i];
            int nextColumn = column + horizontal[i];
            if (isSafe(nextRow, nextColumn) && board[nextRow][nextColumn] == 0) {
                count++;
            }
        }
        return count;
    }

    private void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
    }
}
