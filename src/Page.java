import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Page {
    private String name;

    public String getName() {
        return name;
    }

    public Page(String name) {
        this.name = name;
    }
    public void writeContact(String masecet,String perek,String contact){
        File b = new File("C:\\Shas");
        if (!b.exists()){
            b.mkdir();
        }
        File mas = new File(b.getAbsolutePath(),masecet);
        if (!mas.exists()){
            mas.mkdir();
        }
        File per = new File(mas.getAbsolutePath(),perek);
        if (!per.exists()){
            per.mkdir();
        }
        File page = new File(per.getAbsolutePath(),nameOfDPage(name));
        if (!page.exists()){
            page.mkdir();
        }
        File amud = new File(page.getAbsolutePath(),AB(name));

        try {
            FileWriter fw = new FileWriter(amud,true);
            fw.write(contact);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                '}';
    }

    public static String AB(String line){
        String[] str = line.split(" ");
        return   "עמוד " + str[2];
    }
    public String nameOfDPage(String line){
        String[] str = line.split(" ");
        String name = "";
        for (int i = 0; i < 2; i++) {
            name += str[i] + " ";
        }
        return name.trim();
    }
}
