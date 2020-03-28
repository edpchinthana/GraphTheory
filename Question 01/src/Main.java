import java.util.*;
public class Main {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String s = input.nextLine();

        for(int i = 0;i < n;i++){
            String s1[] = input.nextLine().split(" ");

            int Cities = Integer.parseInt(s1[0]);
            int Roads = Integer.parseInt(s1[1]);
            int CostPerLib = Integer.parseInt(s1[2]);
            int CostPerRoad = Integer.parseInt(s1[3]);
            int answer = 0;

            int[][] n1 = new int[Roads][2];
            for(int x=0;x<Roads;x++){
                String s2[] = input.nextLine().split(" ");
                n1[x][0]=Integer.parseInt(s2[0]);
                n1[x][1]=Integer.parseInt(s2[1]);
            }

            //Calculations
            if(CostPerLib < CostPerRoad){
                System.out.println(CostPerLib * Cities);
            }else{


            }

        }
    }
}
