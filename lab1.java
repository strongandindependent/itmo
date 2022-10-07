public class Main {
    public static void main(String[] args) {
		int xk = 5, yk = 7, xl1 = 4, yl1 = 7, xl2 = 4, yl2 = 1, xl3 = 2, yl3 = 9, c1, c2, c3;
		if (xk > 8 || yk > 8 || xl1 > 8 || yl1 > 8 || xl2 > 8|| yl2 > 8|| xl3 > 8 || yl3 > 8) {
			System.out.println("введены неверные координаты");
		}
		if (xk == xl1 || xk == xl2 || xk == xl3 || yk == yl1 || yk == yl2 || yk == yl3) {
			System.out.println("введены совпадающие координаты");
		}
		else {
			c1 =  (xk == xl1 || yk == yl1) ? (xl1 - xk + yl1 - yk) : 0;
			c2 = (xk == xl2 || yk == yl2) ? (xl2 - xk + yl2 - yk) : 0;
			c3 = (xk == xl3 || yk == yl3) ? (xl3 - xk + yl3 - yk) : 0;
			if ((xl1 == xl2 || yl1 == yl2) && (c1 * c2 > 0 )) {
				if (Math.abs(c1)>Math.abs(c2)) {
					c1 = 0;
				}
				else {
					c2 = 0;
				}
			}
			if ((xl2 == xl3 || yl2 == yl3) && (c2 * c3 > 0 )) {
				if (Math.abs(c3)>Math.abs(c2)) {
					c3 = 0;
				}
				else {
					c2 = 0;
				}
			}
			if ((xl1 == xl3 || yl1 == yl3) && (c1 * c3 > 0 )) {
				if (Math.abs(c3)>Math.abs(c1)) {
					c3 = 0;
				}
				else {
					c1 = 0;
				}
			}
			if (c1 ==  0 && c2 == 0 && c3 == 0) {
				System.out.print("король не под ударом");
			}
			else {
				if (c1 != 0) {
					System.out.print("атакует ладья 1");
				}
				if (c2 !=  0) {
				System.out.print("атакует ладья 2");
			}
				if (c3 !=  0) {
					System.out.print("атакует ладья 3");
			}
			}

    }
}
}
