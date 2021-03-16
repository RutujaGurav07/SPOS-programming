import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of process : ");
        int process = input.nextInt();
        System.out.println("You entered " + process);
        int[][] arr = new int[process][6];
        int temp ,counter=0, preFT=0;
        for (int i = 0; i < process; i++) {
            arr[i][0] = i + 1;
            System.out.println("Enter arrival time of process " + (i + 1) + " : ");
            arr[i][1] = input.nextInt();

            System.out.println("Enter Burst time of process " + (i + 1) + " : ");
            arr[i][2] = input.nextInt();
        }

        // Sorting array

        for (int i = 0; i < process-1; i++) {
            for (int j = 0; j < process - i - 1; j++) {

                if (arr[j][1] > arr[j + 1][1]) {
                    for (int k = 1; k < 3; k++) {

                        temp = arr[j][k];
                        arr[j][k] = arr[j + 1][k];
                        arr[j + 1][k] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < process; i++) {
            if (arr[i][1]>preFT)
            {
                counter=arr[i][1];
                // System.out.println("in if loop counter "+ counter );

            }
            else{
                counter=preFT;
                // System.out.println("in else loop counter "+ counter );

            }
            arr[i][3] = arr[i][2] + counter;// finishing time
            arr[i][5]=arr[i][3] - arr[i][1];// turnaround time
            arr[i][4]=arr[i][5] - arr[i][2];
            preFT=arr[i][3];// update counter

        }
        // Display process

        System.out.println("   \n  \t  :  table :\n   ");
        System.out.println(" : NO : AT : BT : FT : WT : TT :");

        for (int i = 0; i < process; i++) {
            System.out.print(" : " + arr[i][0] + " : ");
            System.out.print(arr[i][1] + "  : ");
            System.out.print(arr[i][2] + "  : ");
            System.out.print(arr[i][3] + "  : ");
            System.out.print(arr[i][4] + "  : ");
            System.out.println(arr[i][5] + "  : ");
        }

        // int arr[process][5];

    }

}
