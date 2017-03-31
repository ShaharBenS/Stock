package SharedClasses;

/**
 * Created by Shahar on 30/03/17.
 */
public class Date
{
    public short year;
    public byte month;
    public byte day;

    public Date(int _year,int _month,int _day)
    {
        this.year = (short) _year;
        this.month = (byte) _month;
        this.day = (byte) _day;
    }
    public Date(short _year,byte _month,byte _day)
    {
        this.year = _year;
        this.month = _month;
        this.day = _day;
    }
    public Date(Date date)
    {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }
    public Date(String date)
    {
        String [] strings = date.split("\\.");
        day = Byte.parseByte(strings[0]);
        month = Byte.parseByte(strings[1]);
        year = Short.parseShort(strings[2]);
    }

    @Override public String toString()
    {
        return day+"."+month+"."+year;
    }
    public boolean equals(Date date)
    {
        if(date == null){return false;}
        return year == date.year && month == date.month && this.day == date.day;
    }
}
