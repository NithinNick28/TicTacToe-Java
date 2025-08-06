import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
        int boardWidth=650;
        int boardeight=650;
        JFrame frame=new JFrame("Tic-Tac-Toe");
        JLabel textLabel = new JLabel();
        JPanel textPanel = new JPanel();
        JPanel boardPanel = new JPanel();

        JButton[][] board = new JButton[3][3];
        String playerX = "X";
        String playerO = "O";
        String currentplayer = playerX;

        boolean gameover = false;
        int turns = 0;

       TicTacToe(){
        frame.setVisible(true);
        frame.setSize(boardWidth,boardeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.black);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial",Font.BOLD,50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel,BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for(int r=0;r<3;r++){
                for(int c=0;c<3;c++){
                        JButton tile = new JButton();
                        board[r][c] = tile;
                        boardPanel.add(tile);

                        tile.setBackground(Color.white);
                        tile.setForeground(Color.BLACK);
                        tile.setFont(new Font("Arial",Font.BOLD,120));
                        tile.setFocusable(false);
                        //tile.setText(currentplayer);

                        tile.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                        if(gameover){
                                                return;
                                        }
                                        JButton tile = (JButton) e.getSource();
                                        if(tile.getText() == ""){
                                                tile.setText(currentplayer);
                                                turns++;
                                                checkWinner();
                                                if(!gameover){
                                                        currentplayer = currentplayer == playerX? playerO : playerX;
                                                        textLabel.setText(currentplayer + "'S Turn");
                                                }

                                        }
                                }
                        });

                }
        }
        JButton restartButton = new JButton("Restart");
        restartButton.setFocusable(false);
        restartButton.addActionListener(e -> resetGame());
        textPanel.add(restartButton, BorderLayout.EAST);

       }
                void checkWinner(){
                        //horzontal
                        for(int r=0;r<3;r++){
                                if(board[r][0].getText() == "") continue;

                                if(board[r][0].getText() == board[r][1].getText()&&
                                   board[r][1].getText() == board[r][2].getText()){
                                for(int i=0;i<3;i++){
                                        setWinner(board[r][i]);
                                }
                                        gameover = true;
                                        return;
                                   }
                        }
                        //vertical
                        for(int c=0;c<3;c++){
                                if(board[0][c].getText() == "") continue;

                                if(board[0][c].getText() == board[1][c].getText() &&
                                   board[1][c].getText() == board[2][c].getText()){
                                        for(int i=0;i<3;i++){
                                                setWinner(board[i][c]);
                                        }
                                        gameover=true;
                                        return;
                                   }
                        }
                        //diagonally
                        if(board[0][0].getText() == board[1][1].getText() &&
                           board[1][1].getText() == board[2][2].getText() &&
                           board[0][0].getText() != ""){
                                for(int i=0;i<3;i++){
                                        setWinner(board[i][i]);
                                }
                                gameover=true;
                                return;
                           }
                        //antidiagonally
                        if(board[0][2].getText() == board[1][1].getText() &&
                           board[1][1].getText() == board[2][0].getText() &&
                           board[0][2].getText() != ""){
                           setWinner(board[0][2]);
                           setWinner(board[1][1]);
                           setWinner(board[2][0]); 
                           gameover = true;
                           return;
                        }     
                if(turns==9){
                        for(int r=0;r<3;r++){
                                for(int c=0;c<3;c++){
                                        setTie(board[r][c]);                                     
                                }
                        }
                gameover = true;
                }                     
                }
        void setWinner(JButton tile){
                tile.setForeground(Color.green);
                tile.setBackground(Color.gray);
                textLabel.setText(currentplayer + " " + "is the winner");
        }
        void setTie(JButton tile){
                tile.setForeground(Color.red);
                tile.setBackground(Color.BLACK);
                textLabel.setText("Tie");
        }
        void resetGame() {
                currentplayer = playerX;
                textLabel.setText("Tic-Tac-Toe");
                gameover = false;
                turns = 0;

                for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                                board[r][c].setText("");
                                board[r][c].setBackground(Color.white);
                                board[r][c].setForeground(Color.black);
        }
    }
}

}
