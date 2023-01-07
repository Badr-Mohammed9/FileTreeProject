import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame {
    private static final int SIZE = 3;
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private boolean playerOneTurn = true;

    public TicTacToe() {
        setLayout(new GridLayout(SIZE, SIZE));
        setSize(300, 300);
        setTitle("Tic Tac Toe");

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener());
                buttons[row][col] = button;
                add(button);
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            // Determine the row and column of the button that was clicked
            int row = -1;
            int col = -1;
            for (int r = 0; r < SIZE; r++) {
                for (int c = 0; c < SIZE; c++) {
                    if (buttons[r][c] == button) {
                        row = r;
                        col = c;
                        break;
                    }
                }
            }

            // Make sure the button has not already been clicked
            if (row == -1 || col == -1 || !buttons[row][col].getText().equals("")) {
                return;
            }

            // Set the text of the button to X or O
            if (playerOneTurn) {
                button.setText("X");
            } else {
                button.setText("O");
            }
            playerOneTurn = !playerOneTurn;

            // Check for a winner
            if (isWinner()) {
                // Display a message to the user
                JOptionPane.showMessageDialog(TicTacToe.this, "You win!");
            }
        }
    }

    private boolean isWinner() {
        // Check rows
        for (int row = 0; row < SIZE; row++) {
            if (!buttons[row][0].getText().equals("") && 
                buttons[row][0].getText().equals(buttons[row][1].getText()) &&
                buttons[row][1].getText().equals(buttons[row][2].getText())) {
                return true;
            }
        }
        return false;
    }
}
           
