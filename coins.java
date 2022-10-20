public class Main {
    public static void main(String[] args) {
        int a = 20;
        int z = 100 - a;
        System.out.print(z < 0 ? "error" : z == 0 ? "сдачи нет" : "");
        System.out.print(z >= 50 ? z/50 + " монет по 50 " : "");
        z %= 50;
        System.out.print(z >= 25 ? z / 25 + " монет по 25 " : "");
        z %= 25;
        System.out.print(z >= 10 ? z / 10 + " монет по 10 " : "");
        z %= 10;
        System.out.print(z >= 5 ? z / 5 + " монет по 5 " : "");
        z %= 5;
        System.out.print(z > 0 ? z + " монет по 1 " : "");
    }
}
