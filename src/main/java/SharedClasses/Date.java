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
    public Date(java.sql.Date date)
    {
        System.out.println("This method should be implemented! Class:Date, Line:32");
    }

    @Override public String toString()
    {
        return day+"/"+month+"/"+year;
    }
}
