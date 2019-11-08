package sk.itsovy.onofrej.project;

import jdk.jshell.spi.ExecutionControl;

import java.util.Random;

public class MyArray implements ArrayMethods {

    private int[] arr;
    private int size;

    public MyArray(int size) {
        if(size<=0)
            error("Cannot declare array of size: "+size);

        this.size = size;
        arr=new int[size];

        resetArrayToZerro();
    }

    private void resetArrayToZerro() {
         for(int i=0;i<size;i++)
            arr[i]=0;
    }

    public MyArray(int[] input){
        if(input==null || input.length==0)
            error("Cannot declare an array!");

        this.arr=input;
        this.size=input.length;
    }

    public int getSize() {
        return size;
    }


    @Override
    public double getAverageValue() {

        int sum=0;
        for(int value:arr)
            sum+=value;
        return (double)sum/size;
    }

    @Override
    public int min() {
        int min=arr[0];
        for(int i=1;i<size;i++)
            if(min>arr[i])
                min=arr[i];

        return min;
    }

    @Override
    public int max() {
        int max=arr[0];
        for(int number:arr)
            if(max<number)
                max=number;

        return max;
    }

    @Override
    public int min2() {

        error("Not supported method: min2()");
        return 0;
    }

    private void error(String message) {
        System.out.println(message);
        System.out.println("Application will terminate !");
        System.exit(1);
    }

    @Override
    public int max2() {
        return 0;
    }

    @Override
    public void generateValues(int a, int b) {
        if(a>b)
            return;
        Random rnd=new Random();
        for(int i=0;i<size;i++)
            arr[i]=rnd.nextInt(b-a+1)+a;
    }

    @Override
    public boolean contains(int value) {
        for(int item:arr) {
            if (item == value)
                return true;
        }
        return false;
    }

    @Override
    public int countOfValues(int value) {
        int count=0;
        for(int item:arr) {
            if (item == value)
                count++;
        }

        return count;
    }

    @Override
    public int countOfEvenValues() {
        return 0;
    }

    @Override
    public void incrementValues() {

    }

    @Override
    public void sort(boolean asc) {
        // buble sort
        int i,j,temp;
        for(i=0;i<size-1;i++)
            for(j=0;j<size-1-i;j++)
                if( (asc==true && arr[j]>arr[j+1]) || (asc==false && arr[j]<arr[j+1] ))
                {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
    }

    @Override
    public void addItem(int newValue) {

    }

    @Override
    public void addItem(int newValue, int position) {
        if(position<0)
            return;
        if(position>=size)
            addItem(newValue);
        else{
            int[] newArr = new int[size+1];
            for(int i=0;i<position;i++)
                newArr[i]=arr[i];

            newArr[position]=newValue;

            for(int i=position;i<size;i++)
                newArr[i+1]=arr[i];

            size++;
            this.arr=newArr;
        }
    }

    @Override
    public int[] copy() {
        return arr.clone();
    }

    @Override
    public int getItem(int position) {
        return 0;
    }

    @Override
    public String toString() {
        String ret="";
        for(int value:arr)
            ret+=value+"  ";

        return ret;
    }

    public void reverse(){
        for(int i=0;i<size/2;i++){
            int temp=arr[i];
            arr[i]=arr[size-1-i];
            arr[size-1-i]=temp;
        }
    }

    public void randommize(){
        Random rnd=new Random();
        for(int i=0;i<2*size;i++){
            int index1=rnd.nextInt(size);
            int index2=rnd.nextInt(size);
            int temp=arr[index1];
            arr[index1]=arr[index2];
            arr[index2]=temp;
        }
    }
}
