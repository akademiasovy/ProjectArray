package sk.itsovy.onofrej.array2d;

import java.util.Random;

public class Main {
    private final static int numRows=4;
    private final static int numCols=4;

    public static void main(String[] args) {

        Random rnd =new Random();
        int[][] arr;
        int r,c;

        arr= new int[numRows][numCols];
        for(r=0;r<numRows;r++){
            for(c=0;c<numCols;c++){
                arr[r][c]=rnd.nextInt(10);
            }
        }

        for(r=0;r<numRows;r++){
            for(c=0;c<numCols;c++){
                if(arr[r][c]<10)
                    System.out.print(" ");
                System.out.print(arr[r][c]+"  ");
            }
            System.out.println();
        }

        int max=arr[0][0];
        for(r=0;r<numRows;r++)
            for(c=0;c<numCols;c++)
                if(max<arr[r][c])
                    max=arr[r][c];
        System.out.println("Max value : "+max);

        int maxColSum=0;
        int column=0;
        for(r=0;r<numRows;r++)
            maxColSum+=arr[r][0];

        int sum=0;
        for(c=1;c<numCols;c++) {
            sum = 0;
            for (r = 0; r < numRows; r++)
                sum+=arr[r][c];
            if(sum>maxColSum){
                maxColSum=sum;
                column=c;
            }
        }
        System.out.println("Max column value : "+column+" [ sum: "+ maxColSum+" ]");

        int minRC=numCols<numRows?numCols:numRows;
        int mul=1;
        for(r=0;r<minRC;r++) {
            mul*=arr[r][r];
        }
        System.out.println("Multiplication of main diagonale is: "+mul);

        System.out.println();
        System.out.println("Transp:");
        for(c=0;c<numCols;c++){
            for(r=0;r<numRows;r++){
                if(arr[r][c]<10)
                    System.out.print(" ");
                System.out.print(arr[r][c]+"  ");
            }
            System.out.println();
        }

        int[][] tictactoe = {{1,0,2},{0,1,2}, {0,2,0}};
    }
}
