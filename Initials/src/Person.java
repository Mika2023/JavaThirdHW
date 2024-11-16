public class Person {
    private NameFormat name;
    private AgeFormat age;

    public Person(String name, String secName, String fathName, String date){
        this.name = new NameFormat(secName,name,fathName);
        this.age = new AgeFormat(date);
    }
    public Person(String name, String secName, String date){
        this.name = new NameFormat(secName,name);
        this.age = new AgeFormat(date);
    }
    public Person(){
        this.name = new NameFormat();
        this.age = new AgeFormat();
    }

    public void printSex(){
        System.out.println(this.name.getSex());
    }
    public void printInitials(){
        try{
            System.out.println(this.name.getInitials());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void printAge(){
        System.out.println(this.age.formatAge());
    }
    public void printAll(){
        try {
            System.out.println(this.name.getInitials()+", " + this.age.formatAge()+", "+this.name.getSex());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    }
}
