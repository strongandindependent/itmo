//Дан целочисленный массив размера MxN, заполненный построчно случайными значениями в диапазоне от -99 до 99.
//Этот массив вывести на экран. Заменить исходный массив новым, в котором продублирован (вставлен рядом) столбец,
//содержащий максимальный элемент исходного массива. Если таких столбцов несколько надо продублировать
//последний из них. Получившийся массив вывести на экран. M и N задаются в main().
import java.util.Random; 
public class massiv {

      public static void main(String[] args) { 
       int N = 2, M = 3;
       int[][] matrice = new int[N][M];
       create(matrice);
       print(matrice);

       int max = Max(matrice);
       int [][] new_matrice = change(matrice, max);
       print(new_matrice);
    } 
      public static void create(int[][] matrice) { 
          Random random = new Random(); 
          for (int i = 0; i < matrice.length; i++) { 
              for (int j=0;j < matrice[i].length; j++) 
                  matrice[i][j] = random.nextInt(-99, 100); 
          } 
      }  

        static int Max(int[][]matrice) { 
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
      
       static int[][] change(int[][]matrice, int columnNum) {
         int[][] Newmatrice = new int[matrice.length][matrice[0].length + 1];
         int margin = 0;

          for (int i = 0; i < matrice.length; i++) { 
              for (int j = 0; j < matrice[i].length; j++) { 
                  if (j != columnNum) { 
                      Newmatrice[i][j + margin] = matrice[i][j]; 
                  }                                  
                  else{
                    Newmatrice[i][j] = matrice[i][columnNum];
                    Newmatrice[i][j+1] = matrice[i][columnNum];
                    margin++;
                  }
              } 

              margin = 0;
          } 
          return Newmatrice;
      }

      static void print(int[][]matrice) {       
        System.out.println();
          for (int i = 0; i < matrice.length; i++) { 
              for (int j = 0; j < matrice[i].length; j++)
                  System.out.print(matrice[i][j] + " ");
              System.out.println(); 
          } 
      } 
 }
