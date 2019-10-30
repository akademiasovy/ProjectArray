package sk.itsovy.onofrej.school;

public class Test {
    public void test(){
        String[] names={"Ivan","Peter","Erik","Zuzana","Leo","Viliam","Fero","Miroslav"};

        // vypis vsetkych mien
        for(int i=0;i<names.length;i++){
            System.out.println(names[i]+"  ");
        }

        for(String name:names){
            System.out.println(name);
        }

        //vypis mien obsahujucich samohlasku a
        for(int i=0;i<names.length;i++){
            if( names[i].contains("a") || names[i].contains("A") )
                System.out.println(names[i]+"  ");
        }

        //vypis najdlhsieho mena
        int max=names[0].length();
        for(int i=1;i<names.length;i++){
            if( names[i].length() > max )
                max=names[i].length();
        }
        for(int i=0;i<names.length;i++){
            if(names[i].length()==max)
                System.out.println(names[i]+"  ");
        }

        //vypis najkratsieho mena
        int min=names[0].length();
        for(int i=1;i<names.length;i++){
            if( names[i].length() < min )
                min=names[i].length();
        }
        for(int i=0;i<names.length;i++){
            if(names[i].length()==min)
                System.out.println(names[i]+"  ");
        }

        //vypis mien velkymi pismenami
        for(int i=0;i<names.length;i++){
            System.out.println(names[i].toUpperCase()+"  ");
        }


        // vypis mien bez samohlasok
        for(int i=0;i<names.length;i++){
            String meno=names[i];
            for(int j=0;j< meno.length();j++){
                String z = String.valueOf(meno.charAt(j));
                if("AEIOUYaeiouy".contains(z))
                    System.out.print(".");
                else
                    System.out.print(z);

            }
            System.out.print("  ");
        }



    }
}
