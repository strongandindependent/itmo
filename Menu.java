package g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// класс меню
public class Menu extends JMenuBar implements ActionListener {
    // создаем переменную игрового поля
    GameField field;
    // создаем переменную игрового фрейма
    private GameOfFifteen game;
    // устанавливаем шрифт
    private final Font font = new Font("Arial", Font.PLAIN, 16);

    // в конструкторе создаем меню и добавляем все необходимые подпункты
    public Menu(GameField field) {

        this.field = field;

        // создаем меню File
        JMenu file = new JMenu("File"); // ctrl + alt + F
        // задаем шрфит
        file.setFont(font);
        // задаем мнемоник
        file.setMnemonic(KeyEvent.VK_F);

        // создаем меню Help
        JMenu help = new JMenu("Help"); //alt + H
        // задаем шрфит
        help.setFont(font);
        // задаем мнемоник
        help.setMnemonic(KeyEvent.VK_H);

        // создаем подпункт новой игры
        JMenuItem newgame = new JMenuItem("New game"); // ctrl + N
        newgame.setFont(font);
        newgame.setMnemonic(KeyEvent.VK_N);
        // устанавливаем акселератор
        newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        // добавляем обработчик события
        newgame.addActionListener(this);
        // добавляем подпункт в меню File
        file.add(newgame);

        // добавляем сепаратор
        file.addSeparator();

        JMenuItem exit = new JMenuItem("Exit"); // ctrl + E
        exit.setFont(font);
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        exit.addActionListener(this);
        file.add(exit);

        // создаем подпункт About
        JMenuItem about = new JMenuItem("About"); // ctrl + A
        about.setFont(font);
        about.setMnemonic(KeyEvent.VK_A);
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        about.addActionListener(this);
        help.add(about);

        // добавляем оба пункта подменю в меню
        add(file);
        add(help);
    }

    // обработчик события меню
    public void actionPerformed(ActionEvent e) {
        String comStr = e.getActionCommand();
        switch (comStr) {
            // начинаем новую игру
            case "New game" -> {
                field.change(15);
                field.shuffle();
                field.reset();
            }
            // выходим из программы
            case "Exit" -> System.exit(0);
            // вызываем диалоговое окно About
            case "About" -> {
                JLabel text = new JLabel("Фролова Ульяна Р3167 2023");
                text.setFont(font);
                // создаем модальное окно
                JOptionPane.showMessageDialog(game, text, "About", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
