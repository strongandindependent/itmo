package g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


// класс игрового поля
public class GameField extends JPanel {
    GameField field = this;

    // задаем цвет заднего фона
    private static final Color Background_COLOR = new Color(194, 201, 218, 255);

    // задем цвет кнопок
    private static final Color Foreground_COLOR = new Color(68, 81, 115, 255);

    // задаем шрифт
    private final Font font = new Font("Helvetica", Font.PLAIN, 16);

    // создаем переменную фрейма
    private GameOfFifteen game;
    // количество плиток
    private final int SIZE = 16;

    // позиция пустой плитки
    int blank = 15;

    // массив плиток размерностью 16
    Tile[] cells = new Tile[SIZE];

    // в конструкторе задаем менеджер компановки и создаем плитки
    public GameField() {
        // задаем менеджер компановки GridLayout
        setLayout(new GridLayout(4, 4));
        // устанавливаем цвет заднего фона
        setBackground(Background_COLOR);

        // в цикле создаем клетки
        for (int i = 0; i < SIZE - 1; i++) {
            cells[i] = new Tile(i + 1);
            // задаем обработчик клика мышки
            cells[i].addActionListener(new ClickListener());
            // устанавливаем фокус клавиатуры
            cells[i].setFocusable(false);
        }
        // создаем пустую плитку в последней позиции массива
        cells[15] = new Tile();

        // перемешиваем поле
        shuffle();
        reset();
    }

    // метод перешивания плиток в массиве
    public void shuffle() {
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            int a = Math.abs(r.nextInt() % 15);
            int b = Math.abs(r.nextInt() % 15);

            Tile c = cells[a];
            cells[a] = cells[b];
            cells[b] = c;

            int c_num = cells[a].location;
            cells[a].location = cells[b].location;
            cells[b].location = c_num;
        }
    }

    // поменять плитки местами с i
    public void change(int i) {
        cells[i].location = blank;
        Tile c;
        c = cells[blank];
        cells[blank] = cells[i];
        cells[i] = c;
        blank = i;
    }

    // сброить поле
    public void reset() {
        // очистить поле
        // removeAll();
        // добавить плитки из массива
        for (int i = 0; i < SIZE; i++) add(cells[i]);
        revalidate();

        // проверяем не решена ли игра
        isSolved();
    }

    // метод проверки выигрыша
    public void isSolved() {

        // если плитки стоят не на своих места, метод завершает работу
        for (int i = 0; i < SIZE - 1; i++) {
            if (!cells[i].getText().equals("" + (i + 1))) return;
        }
        // если все на своих местах - вывести модальное окно о завершении игры
        JLabel text = new JLabel("Ура! Вы выиграли игру. Осталось выиграть жизнь");
        text.setFont(font);
        // выводим сообщение
        JOptionPane.showMessageDialog(game, text, "", JOptionPane.PLAIN_MESSAGE);

        // перемешать плитки
        shuffle();
    }

    // обраточик клика мышки
    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Tile button = (Tile) e.getSource();
            int location = button.location;

            if (location - 4 == field.blank || location + 4 == field.blank || location - 1 == field.blank && field.blank % 4 != 3 || location + 1 == field.blank) {
                field.change(location);
                field.reset();
            }
        }
    }

    // обработчик нажатия кнопок клавиатуры
    private class KeyClickListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int location = -1;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    location = blank + 4;
                    break;
                case KeyEvent.VK_DOWN:
                    location = blank - 4;
                    break;
                case KeyEvent.VK_LEFT:
                    location = blank + 1;
                    break;
                case KeyEvent.VK_RIGHT:
                    location = blank - 1;
                    break;
            }
            if (location >= 0 && location < SIZE && (location / 4 == blank / 4 || location % 4 == blank % 4)) {
                field.change(location);
                field.reset();
            }
        }
    }



    // класс плитки
    private class Tile extends JButton {

        // получаем размер плитки
        private final int height = Toolkit.getDefaultToolkit().getScreenSize().height/2;
        // переменная позиции плитки
        private int location;
        // в конструкторе задаем шрифт, цвет, позицию
        public Tile(int n) {
            setText("" + n);
            setFont(new Font("Helvetica", Font.PLAIN, 4 * (height / 28)));
            setForeground(Foreground_COLOR);
            location = n - 1;
        }
        // делаем клетку видимой
        public Tile() {
            setVisible(false);
        }
    }
}
