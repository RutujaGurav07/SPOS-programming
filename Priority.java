import java.util.Scanner;

public class Priority {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of process : ");
        int process = input.nextInt();
        System.out.println("You entered " + process);
        int[][] arr = new int[process][7];
        int temp,counter=0;

        for (int i = 0; i < process; i++) {

            arr[i][0] = i + 1;

            System.out.println("Enter Priority of process " + (i + 1) + " : ");
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
        
        // calculation

        for (int i = 0; i < process; i++) {


            arr[i][3]=arr[i][2]+counter;//finishing time
            arr[i][4]=counter;//waiting time
            arr[i][5]=arr[i][2]+arr[i][4];//turnaround time            
            counter=arr[i][3];//update counter



        }
            //Display process

            System.out.println("   \n  \t  :  table : \n \n Assumming all the process arrival in 0 interval\n " );
            System.out.println(" : No : P : BT : FT : WT : TT :" );
    
    
            for(int i=0;i<process;i++)
            {
                System.out.print(" : "+arr[i][0] + " : ");
                System.out.print(arr[i][1] + "  : ");
                System.out.print(arr[i][2] + "  : ");
                System.out.print(arr[i][3] + "  : ");
                System.out.print(arr[i][4] + "  : ");
                System.out.println(arr[i][5] + "  : ");
            }

    }
}