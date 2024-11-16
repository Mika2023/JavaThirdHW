public class App {
    public static void main(String[] args) throws Exception {
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in,StandardCharsets.UTF_8));
        
        // String fullName = br.readLine();
        // String dateBirth = br.readLine();

        // Scanner sc = new Scanner(System.in,"UTF-8");
        // String fullName = sc.nextLine();
        // String dateBirth = sc.nextLine();
        // sc.close();

        //fullName = new String(fullName.getBytes("UTF-8"),Charset.forName("UTF-8"));

        String fullName = "Иванов Иван Иванович";
        String dateBirth = "11/11/2005";

        String[] fullNameSep = fullName.split(" ");
        Person person = new Person(fullNameSep[1], fullNameSep[0], fullNameSep[2], dateBirth);
        person.printAll();
    }
}
