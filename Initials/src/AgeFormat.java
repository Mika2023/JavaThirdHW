import java.util.Calendar;
public class AgeFormat {

    private String date;
    private int age;

    public AgeFormat(String inDate){
        this.date = inDate;
        this.age = -1;
    }
    public AgeFormat(){this("");}

    public Calendar stringToCalendar(){
        String[] parts = this.date.split("/");
        if (parts.length<3) {
            System.out.println("Wrong date format");
            return null;
        }

        try {
            int year = Integer.parseInt(parts[2]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[0]);

            Calendar curCalendar = Calendar.getInstance();
            if ((year>=0 && year<=curCalendar.get(Calendar.YEAR))&&(month>=1 && month<=12)){
                curCalendar.set(Calendar.YEAR,year);
                curCalendar.set(Calendar.MONTH,month);
                if (day>=1 && day<=curCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)){
                    curCalendar.set(Calendar.DATE,day);
                    return curCalendar;
                } 
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return null;
    } 

    public void getAge(){
        Calendar curCalendar = Calendar.getInstance();
        Calendar inCalendar = stringToCalendar();
        if (inCalendar==null) return;

        if (curCalendar.get(Calendar.MONTH)+1>inCalendar.get(Calendar.MONTH) || (curCalendar.get(Calendar.MONTH)+1==inCalendar.get(Calendar.MONTH) && curCalendar.get(Calendar.DATE)>=inCalendar.get(Calendar.DATE)))this.age = curCalendar.get(Calendar.YEAR)-inCalendar.get(Calendar.YEAR);
        else this.age = curCalendar.get(Calendar.YEAR)-inCalendar.get(Calendar.YEAR)-1;
        
    }

    public String formatAge(){
        getAge();
        String res = Integer.toString(this.age) + " ";
        int lastDigit = this.age%10;

        if (this.age>=10 && this.age<=20 || lastDigit==0 || lastDigit>=5) res+="лет";
        else if (lastDigit==1) res+="год";
        else res+="года";

        return res;
    }
}
