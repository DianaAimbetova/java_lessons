import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        //размер массива установливает пользователь
        int size = reader.nextInt();

        int[][] arr = new int[size][size];//собственно двумерный массив
        int count = 0; //счетчик
        /**
         * первая половина массива(идет сначала)
         */
        for(int y = 0; y < size; y++){
            for (int x = count; x < size-count; x++) {
                arr[y][x] = 1;

            }
            count++;
            }
            //обнуляем счетчик
            count = 0;
        /**
         * вторая половина массива(идет с конца)
         */
        for(int y = size-1; y >= 0; y--){
            for(int x = count; x < size-count; x++){
                arr[y][x] = 1;

            }
            count++;
        }

        //вывод на экран
        for(int i = 0; i <  size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + "  ");
            }
        }
            System.out.println();
        }
    }


