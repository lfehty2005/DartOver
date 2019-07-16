public class ReplaceLine {
    String ReplaceLineString;

    void  replaceLine (String s){

        // ИН и ОУТ и разделители значений
        s=s.replace(" OUT: " ,"OUT|");
        s=s.replace(" IN: ","IN|");
        s=s.replace("@","|");
        s=s.replace("\" ","|");
        s=s.replace("|\"","|");
        s=s.replace(" (slbsls)","|");
        s=s.replace(" (","|");
        s=s.replace(")"," ");

        // Убираем лишние разделители
        s=s.replace("||||","|");
        s=s.replace("|||","|");
        s=s.replace("||","|");

        // работа с ТАЙМ убираем лишнее
        s=s.replace(" Central Asia Standard Time","");
        s=s.replace(" Server's System Date and Time:","");
        s=s.replace(" Time:","");
        s=s.replace("slbsls-SLOG","");
        s=s.replace("lmgrd","");
        s=s.replace(" Thu ","");
        s=s.replace(" Fri ","");
        s=s.replace(" Sat ","");
        s=s.replace(" Sun ","");
        s=s.replace(" Mon ","");
        s=s.replace(" Tue ","");
        s=s.replace(" Wed ","");

        this.ReplaceLineString=s;
    }
}

/*
Central Asia Standard Time
OUT:
IN:
"
day=    Thu Fri Sat Sun Mon Tue Wed
 */