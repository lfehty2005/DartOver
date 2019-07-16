import java.util.Arrays;

public class DictionarySpecLog {



    public String [][] string1 = new String [1000000][4]; // словарь ДатаФИО
    public String [][] string2 = new String [1000000][4]; // словарь Модуль+Модуль... (фильтр сессия: ДатаФио+ЧЧММ(сплит(:))
    public int   counterString1 = 1 ;
    public int   counterString2 = 1 ;



    void addDictMainDateFIO (String s) {
        int vseMimo = 0;
        int start=1; // this.counterString1 (3000 последних)
        if (this.counterString1>6000) {start=this.counterString1-3000;}
        String s2=""; //temp this.string1
        for (int i = start; i<this.counterString1+1; i++) {
            s2=this.string1 [i][1];
            if (  s2==null) {s2="";}
            if (s.equals( s2)==false) {
                vseMimo++;
            }
        }
        if (vseMimo == this.counterString1) {
            this.counterString1++;
            this.string1 [this.counterString1][1]= s;
        }
    }



    void addDictMainDateModule (String[] parts) {
        int vseMimo = 0;
        String splitTime[] = new String [2] ;
        String sDFT="", sM="";
        String s2=""; //temp this.string2
        int start=1; // this.counterString1 (3000 последних)

        splitTime = parts[1].split("[:]",3);

        sDFT=parts[0]+"|"+splitTime[0]+":"+splitTime[1]+"|"+parts[2]+"|"+parts[4];
        sM=parts[3];

        if (this.counterString2>6000) {start=this.counterString2-3000;}
        for (int i = start; i<this.counterString2+1; i++) {
            s2=this.string2 [i][1];
            if (  s2==null) {s2="";}
            if (s2.equals(sDFT)==false  ) {
                vseMimo++;
            }
            if (s2.equals(sDFT) ) {
                this.string2 [i][2]=this.string2 [i][2]+"#"+sM;
                //if (parts[2].equals("IN")){System.out.println("*");}
                //if (parts[2].equals("OUT")){System.out.println("&");}
            }
        }
        if (vseMimo == this.counterString2) {
            this.counterString2++;
            this.string2 [ this.counterString2][1]=sDFT;
            this.string2 [ this.counterString2][2]=sM;
            //if (parts[2].equals("IN")){System.out.println("*");}
            //if (parts[2].equals("OUT")){System.out.println("&");}
        }

        String  arr[] = new String [200];
        sM=this.string2 [ this.counterString2][2];
        if (sM!=null){
            arr= sM.split("#" ); // разделяем для сортировки
            Arrays.sort(arr); // сортируем
            sM=String.join("#", arr); // соединяем


        }

    }



    void addDictContent (String[] parts){
            /*
            String[] parts
                0=date
                1=time
                2=in-out
                3=module
                4=fio
                5=active directory
            */
            String s2;

        // добавление ИНов и АУТов в СПРАВОЧНИК
        for (int i = 1; i<this.counterString1+1; i++) {
            s2=parts[0]+"|"+parts[4];

            if (s2.equals( this.string1 [i][1])) {
                if (parts[2].equals("IN")){
                    this.string1 [i][2]=this.string1 [i][2]+parts[1]+"|"+parts[3]+"|";
                }
                if (parts[2].equals("OUT")){
                    this.string1 [i][3]=this.string1 [i][3]+parts[1]+"|"+parts[3]+"|";
                }

            }
        }  // endif I
    }



}




