public class NameFormat {

    private String secondName;
    private String firstName;
    private String fathersName;

    public NameFormat(String secName, String firstName, String fathName){
        this.secondName = secName;
        this.firstName = firstName;
        this.fathersName = fathName;
    }
    public NameFormat(String secName, String firstName){
        this(secName,firstName,"");
    }
    public NameFormat(){
        this("","");
    }

    public String getSex(){
        if (this.fathersName=="") return "Определить не удалось";
        if (this.fathersName.substring(this.fathersName.length()-2,this.fathersName.length()).equals("на")) return "Ж";
        else if (this.fathersName.substring(this.fathersName.length()-2,this.fathersName.length()).equals("ич")) return "М";
        else return "Определить не удалось";
    }

    public String getInitials() throws Exception{
        if (this.firstName=="" || this.secondName=="") throw new Exception("Wrong format of name");
        else{
            String res = this.secondName+" ";
            res+=this.firstName.charAt(0)+".";
            if (this.firstName.contains("-")) res+="-"+this.firstName.charAt(this.firstName.indexOf("-")+1)+". ";
            if (this.fathersName!=""){
                res+=this.fathersName.charAt(0)+".";
                if (this.fathersName.contains("-")) res+="-"+this.fathersName.charAt(this.fathersName.indexOf("-")+1)+". ";
            }
            return res;
        }
    }
}
