import java.util.Scanner;
import java.util.LinkedList;

public class LUR_pg_repalcement {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter frame size : ");
        int framesize = input.nextInt();
        System.out.println("Enter framestring lenght : ");
        int size = input.nextInt();
        int[] frame_string = new int[size];
        int[][] arr = new int[framesize][2];
        int pg_fault = 0, pg_hit = 0;
        System.out.println(" Enter frame string : ");
        for (int i = 0; i < framesize; i++) {
            arr[i][0]=-1;
            arr[i][1]=-1;
        }
        for (int i = 0; i < size; i++) {
            int newframe = input.nextInt();
            if (ispersent(newframe, arr, framesize)) {
                pg_hit++;
                System.out.println(" page hit: ");

            } else {
                pg_fault++;
                System.out.println(" page foult: ");

                int max = findmax(arr, framesize);
                arr[max][0] = newframe;
                arr[max][1] = 0;
            }

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

    static boolean ispersent(int newframe, int[][] arr, int size) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            arr[i][1]++;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i][0] == newframe) {
                arr[i][1] = 0;
                flag = true;
                break;
            } else {
                flag = false;
            }

        }
        return flag;

    }

}
