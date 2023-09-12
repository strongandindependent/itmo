package g;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// класс обработки собитий клавиатуры
public class Keyboard extends KeyAdapter {
    // создаем переменную игрового поля
    GameField field;

    // в конструкторе получаем и присваиваем игровое поле
    Keyboard(GameField field){
        this.field = field;
    }

    // метод обработки нажтий клавиш
    public void keyPressed(KeyEvent e) {
        // получаем значение клавиши
        int key = e.getKeyCode();
        // получаем пустую клетку
        int blank = field.blank;
        // в зависимоти от нажатой клавиши меняем питки местами
        switch (key) {
            case KeyEvent.VK_UP:
                if (blank < 12) field.change(blank + 4);
                break;
            case KeyEvent.VK_RIGHT:
                if (blank % 4 != 0) field.change(blank - 1);
                break;
            case KeyEvent.VK_DOWN:
                if (blank > 3) field.change(blank - 4);
                break;
            case KeyEvent.VK_LEFT:
                if (blank % 4 != 3) field.change(blank + 1);
                break;
        }
        // обновляем игровое поле
        field.reset();
    }
}
