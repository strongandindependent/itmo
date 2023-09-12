package g;

import javax.swing.*;
import java.awt.*;


public class GameOfFifteen extends JFrame {

    // в конструкторе устанавливаем все необходимы размеры и параметры
    public GameOfFifteen() {
        // получаем размер экрана
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // устанавливаем размер окна
        setSize(size.height / 2, size.height / 2);
        // размещаем окно по центру экрана
        setLocationRelativeTo(null);
        // делаем невозможны изменение размеров окна
        setResizable(false);
        // задаем название для окна
        setTitle("Пятнашки");
        // при закрытии окна, программа завершится
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // создаем объект игрового поля
        GameField field = new GameField();
        // задаем меню для окна
        setJMenuBar(new Menu(field));
        // добавляем игровое поле на окно
        getContentPane().add(field);
        // добавляем обработчик клавиатуры
        addKeyListener(new Keyboard(field));

        // устанавливаем фокус клавиатуры
        setFocusable(true);
        // делаем окно видимым
        setVisible(true);
    }

    public static void main(String[] args) {
        // запускаем нашу игру
        SwingUtilities.invokeLater(() -> new GameOfFifteen().setVisible(true));
    }
}
