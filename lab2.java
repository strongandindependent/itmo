//Дан целочисленный массив размера MxN, заполненный построчно случайными значениями в диапазоне от -99 до 99.
//Этот массив вывести на экран. Заменить исходный массив новым, в котором продублирован (вставлен рядом) столбец,
//содержащий максимальный элемент исходного массива. Если таких столбцов несколько надо продублировать
//последний из них. Получившийся массив вывести на экран. M и N задаются в main().

//создаем отдельный массив, далее ищем столбец с максимальным массивом,
//берем значения максимального массива, если номер столбца не равен номеру того, в котором максимальныйь эл-т
//присваиваем значения из созданного, 
//если равен, то идем с помощью отступа, оставляем столбец с максимальным и добавляем в следующий столбец эти же значения
import java.util.Random; 
public class massiv {

      public static void main(String[] args) { 
       int N = 2, M = 10;
       int[][] matrice = new int[N][M];
       create(matrice); //создание массив
       print(matrice); //вывод изначального массива
       int max = Max(matrice); 
       int [][] new_matrice = change(matrice, max); // присваивание в массив нового столбца
       print(new_matrice); //вывод нового массива
    } 

      public static void create(int[][] matrice) {  //создание массива
          Random random = new Random(); 
          for (int i = 0; i < matrice.length; i++) { 
              for (int j=0;j < matrice[i].length; j++) 
                  matrice[i][j] = random.nextInt(-99, 100); //
          } 
      }  

        static int Max(int[][]matrice) {  //нахождение максимального элемента массива
          int maxx = -99; 
          int mxcol = 0; 
          for (int i = 0; i < matrice.length; i++) { 
              for (int j = 0; j < matrice[i].length; j++) { 
                  if (matrice[i][j] >= maxx) { 
                      maxx = matrice[i][j]; 
                      mxcol = j; 
                  } 
              } 
          }
          return mxcol; 
         
      } 
    
       static int[][] change(int[][]matrice, int columnNum) { //добавление еще одного столбца с максимальным эл-м
         int[][] Newmatrice = new int[matrice.length][matrice[0].length + 1];
         int margin = 0; //создание переменной - отступа
          for (int i = 0; i < matrice.length; i++) { 
              for (int j = 0; j < matrice[i].length; j++) { 
                  if (j != columnNum) {  //если столбик не равен номеру максимального 
                      Newmatrice[i][j + margin] = matrice[i][j];  //оставляем те же значения
                  }                                  
                  else{ //в ином случае
                    Newmatrice[i][j] = matrice[i][columnNum]; //оба столбика получают значение максимального столбцаЫ
                    Newmatrice[i][j+1] = matrice[i][columnNum];
                    margin++;
                  }
              } 

              margin = 0; //заново обнуляем отступ
          } 
          return Newmatrice;
      }

      static void print(int[][]matrice) {       //вывод нового массива
        System.out.println();
          for (int i = 0; i < matrice.length; i++) { 
              for (int j = 0; j < matrice[i].length; j++)
                  System.out.printf("%5d", matrice[i][j]);
              System.out.println(); 
          } 
      } 
 }
