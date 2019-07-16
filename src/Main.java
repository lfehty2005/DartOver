import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Main {


    public static void main(String[] args) throws IOException {
        String path; 
        path = "src/sample_small.txt";
        FileReader input = new FileReader(path);
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        WriteFile WriteFileObject = new WriteFile ();
        ParserWeek parserWeek = new ParserWeek() ;
        ReplaceLine replaceLine= new ReplaceLine() ;
        String temp , temp1="01.01.1980" ;
        DictionarySpecLog dictionarySpecLog = new DictionarySpecLog ();
        String[] parts;
        Date dateStart, dateFinish;

        dateStart= new Date();
        int lineCounterAdd = 0;
        int lineCounterTime = 0;
        int lineCounterIn = 0;
        int lineCounterOut = 0;
        int ZapiseiBezDat = 0;
        System.out.println("-----открываю файл"    );
        temp ="01.01.1980";
        int raspechatka=1;

        int lineCounterAll ;
        lineCounterAll= 0;
        while ((line = reader.readLine()) != null) {

            lineCounterAll++;

            if ( line.indexOf   (" Time: " )> 0)
            {
                //WriteFileObject.writeFileLogTXT(line+ "\n");
                temp ="01.01.1980";
                replaceLine.replaceLine(line);
                temp=replaceLine.ReplaceLineString;
                parserWeek.parserLineTime(temp);
                temp=parserWeek.parserLine;

                temp1 =temp;
                lineCounterAdd++;
                lineCounterTime++;
                //логика парсинга, и передача переменной для ИН и ОУТ
                if (temp!="01.01.1980") {
                    //System.out.println(temp);
                }
            }


            if ( line.indexOf   (" IN: ")> 0 || line.indexOf  (" OUT: ")> 0)
            {
                replaceLine.replaceLine(line);
                temp=temp1+"|"+replaceLine.ReplaceLineString;

                if (temp1 !="01.01.1980") {
                    //начинаю запись нормализованных строк
                    //WriteFileObject.writeFileLogTXT(temp+ "\n");  // пока отключил, тестирую формирование других таблиц
                    parts = temp.split("[|]",6);

                    //dictionarySpecLog.addDictMainDateFIO (parts[0]+"|"+parts[4]);
                    dictionarySpecLog.addDictMainDateModule (parts );
                    dictionarySpecLog.addDictContent(parts);
                    // записей без дат
                    lineCounterAdd++;
                }

                if (temp1 =="01.01.1980") {
                    ZapiseiBezDat++;
                }

                if ( line.indexOf   (" IN: ")> 0  ) {
                    lineCounterIn++;
                }
                if ( line.indexOf   (" OUT: ")> 0  ) {
                    lineCounterOut++;
                }
                //закрываю цикл парсинга основного файла соответсвующего по статусу

            }




            // если lineCounterAll содержит /6500, то напечатай Прогресс
            if (lineCounterAll/6500 > raspechatka) {
                raspechatka++;
                System.out.println("обработано записей " + lineCounterAll);
            }

        }

        // завершен расчет, печатаем показатели
        System.out.println("-----закрываю файл, добавлено записей " + lineCounterAdd +" из "+ lineCounterAll);
        System.out.println("-найдено записей ДАТА " + lineCounterTime);
        System.out.println("-добавлено записей ИН " + lineCounterIn);
        System.out.println("-добавлено записей ОУТ " + lineCounterOut);
        System.out.println("-записей c датой 01.01.1980 " + ZapiseiBezDat);
        System.out.println("-dictionary " + dictionarySpecLog.counterString1);


        reader.close();


        //WriteFileObject addDictMainDateFIO
        for (int i = 1; i < dictionarySpecLog.counterString1 + 1; i++) {
            if (dictionarySpecLog.string1 [i][1]!=null) {
                //начинаю печать  словаря ДатаФИО в файл
                //WriteFileObject.writeFileLogTXT(dictionarySpecLog.string1[i][1]+"|IN|"+dictionarySpecLog.string1[i][2]+"|OUT|"+ dictionarySpecLog.string1[i][3]+"\n");
            }
        }

        //WriteFileObject addDictMainDateModule
        for (int i = 1; i < dictionarySpecLog.counterString2 + 1; i++) {
            if (dictionarySpecLog.string2 [i][1]!=null) {
                //начинаю печать  словаря ДатаФИОВремяМодуль в файл
                WriteFileObject.writeFileLogTXT(dictionarySpecLog.string2[i][1]+  "|"+ dictionarySpecLog.string2[i][2]+"\n");
            }
        }

        // конец программы, закрытие текстового конекта
        WriteFileObject.closeFileLogTXT();

        System.out.println("-уникальных записей по входам и выходам " + dictionarySpecLog.counterString2);

        dateFinish= new Date();
        System.out.println("-старт " + dateStart  +" -финиш " + dateFinish);


    }

}


