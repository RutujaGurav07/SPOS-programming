import java.util.Scanner;

public class OPR_pg_replacement {
    public static void main(String[] args) {

        // taking input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter frame size : ");
        int windowsize = input.nextInt();
        System.out.println("Enter framestring lenght : ");
        int size = input.nextInt();
        int[] frame_string = new int[size];
        int[][] arr = new int[windowsize][2];

        int pg_fault = 0, pg_hit = 0, k = 0;
        System.out.println(" Enter frame string : ");

        // initial frame widow as -1

        // taking frame string
        for (int i = 0; i < size; i++) {
            frame_string[i] = input.nextInt();
        }

        while (k < size) {
            int newframe = frame_string[k];
            if (k < windowsize) {
                pg_fault++;
                arr[k][0] = newframe;
                arr[k][1] = 0;
                // System.out.println(" page foult: " + newframe);

            } else if (ispersent(newframe, arr, windowsize)) {
                pg_hit++;
                // System.out.println(" page hit : " + frame_string[k]);

            } else {
                pg_fault++;
                // System.out.println(" page foult: ");
                count_1st_occurance(arr, windowsize, size, k, frame_string);
                int max = findmax(arr, windowsize);
                arr[max][0] = newframe;
            }

            k++;
        }
        System.out.println(" page fault: " + pg_fault);
        System.out.println(" page hit : " + pg_hit);

    }

    static int findmax(int[][] arr, int size) {
        int max = 0, index = -1;
        for (int i = 0; i < size; i++) {
            if (max <= arr[i][1]) {
                max = arr[i][1];
                index = i;
            }
        }

        return index;

    }

    static void count_1st_occurance(int[][] arr, int windowsize, int size, int k, int[] frame_string) {

        int x = 0;
        while (x < windowsize) {
            int pg = arr[x][0];
            // System.out.println("pg :" + pg);

            int count = 0;
            for (int i = k; i < size; i++) {
                if (frame_string[i] != pg) {
                    count++;
                    if (frame_string[i] == pg || i == size) {
                        break;
                    }
                }

            }
            arr[x][1] = count;
            // System.out.println(" in  count function : array count : " + arr[x][1]);

            x++;

        }

    }

    static boolean ispersent(int newframe, int[][] arr, int size) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (arr[i][0] == newframe) {
                // System.out.println("in present func arr[i][0]:" + arr[i][0] + "newframe : " + newframe);
                flag = true;
                break;
            } else {
                flag = false;
            }

        }
        return flag;

    }
}
