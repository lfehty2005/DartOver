public class ParserWeek {

        String parserLine;
        int start,end;

    void parserLineTime (String s){
        String s2="";
        start=0;
        end=0;
        this.parserLine ="01.01.1980";

        if ( s.indexOf   ("Jan"  )> 0)
        {
            start=s.indexOf   ("Jan"  );
        }
        if ( s.indexOf   ("Feb"  )> 0)
        {
            start=s.indexOf   ("Feb"  );
        }
        if ( s.indexOf   ("Mar"  )> 0)
        {
            start=s.indexOf   ("Mar"  );
        }
        if ( s.indexOf   ("Apr"  )> 0)
        {
            start=s.indexOf   ("Apr"  );
        }
        if ( s.indexOf   ("May"  )> 0)
        {
            start=s.indexOf   ("May"  );
        }
        if ( s.indexOf   ("Jun"  )> 0)
        {
            start=s.indexOf   ("Jun"  );
        }
        if ( s.indexOf   ("Jul"  )> 0)
        {
            start=s.indexOf   ("Jul"  );
        }
        if ( s.indexOf   ("Aug"  )> 0)
        {
            start=s.indexOf   ("Aug"  );
        }
        if ( s.indexOf   ("Sep"  )> 0)
        {
            start=s.indexOf   ("Sep"  );
        }
        if ( s.indexOf   ("Oct"  )> 0)
        {
            start=s.indexOf   ("Oct"  );
        }
        if ( s.indexOf   ("Nov"  )> 0)
        {
            start=s.indexOf   ("Nov"  );
        }
        if ( s.indexOf   ("Dec"  )> 0)
        {
            start=s.indexOf   ("Dec"  );
        }
        if ( s.indexOf   ("2018"  )> 0)
        {
            end=s.indexOf   ("2018"  );
        }
        if ( s.indexOf   ("2019"  )> 0)
        {
            end=s.indexOf   ("2019"  );
        }
        if ( s.indexOf   ("2020"  )> 0)
        {
            end=s.indexOf   ("2020");
        }

        if ( start> 0 && end>0){
            this.parserLine =s.substring(start,end+4 );
            //System.out.println(this.parserLine);
        }

    }

}


/*
Jan
Feb
Mar
Apr
May
Jun
Jul
Aug
Sep
Oct
Nov
Dec
2018
2019
2020
 */