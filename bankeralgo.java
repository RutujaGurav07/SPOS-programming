import java.util.Scanner;
import java.util.LinkedList;


public class bankeralgo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of process : ");
        int p = input.nextInt();
        System.out.println("Enter number of resources : ");
        int r = input.nextInt();
        int[][] need = new int[p][r];
        int[][] allocation = new int[p][r];
        int[][] max = new int[p][r];
        int[][] avaliable = new int[1][r];
        LinkedList process = new LinkedList();


        System.out.println("Enter max matrix");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                max[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter allocation matrix");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                allocation[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter avaliable matrix");
        
            for (int j = 0; j < r; j++) {
                avaliable[0][j] = input.nextInt();
            }
        
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
               need[i][j]=max[i][j]- allocation[i][j] ;
            }
        }

        System.out.println("max matrix\n");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(max[i][j] + "\t");
            }
            System.out.print("\n");
        }
        
        System.out.println("Allocation matrix\n");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(max[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("need matrix\n");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(max[i][j] + "\t");
            }
            System.out.print("\n");
        }
        int counter=0;
        System.out.print("Safe sequences:");

        while(counter<p)
        {
            int i;
            for (i = 0; i < p; i++) {
                int flag=0;
                if(!process.contains(i))
                {
                    for (int j = 0; j < r; j++) {
                        if (avaliable[0][j]>=need[i][j])
                        {
                            flag = 1;
                            continue;
                        }
                        else
                        {
                            flag =0;
                            break;
                        }

                    }
                }
                if (flag == 1)
                {
                    System.out.print(" P"+(i+1)+"-->");
                    process.add(i);

                    for (int j = 0; j < r; j++) {
                        avaliable[0][j]=avaliable[0][j]+allocation[i][j];
                    }
                    counter++;
                }
                if (i==p && counter>p)
                i=0;
            }

        }
    }

}
