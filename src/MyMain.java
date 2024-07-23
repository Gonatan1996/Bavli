import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        File file = new File(Shas.getFullPath());
        Shas shas = new Shas();
        Masechet masechet = null;
        Perek perek = null;
        Page page = null;

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){
                String line = scan.nextLine();
                switch (lineType(line)){
                    case "masechet":
                        String name = Masechet.nameOfMasechet(line);
                        if (masechet == null || !masechet.getM().equals(name)){
                            masechet = new Masechet(name.trim());
                            shas.setMasechets(masechet);
                        }
                        name = Perek.nameOfPerek(line);
                        if (perek == null ||!perek.getName().equals(name)){
                            perek = new Perek(name.trim());
                            masechet.setPereks(perek);
                        }
                        break;
                    case "perek":
                        name = Perek.nameOfPerek(line);
                        if (perek == null ||!perek.getName().equals(name)){
                            perek = new Perek(name.trim());
                            masechet.setPereks(perek);
                        }
                        break;
                    case "page":
                        name = line.trim();
                        if (page == null || !page.getName().equals(name)){
                            page = new Page(name);
                            perek.setPages(page);
                        }
                        break;
                    case "contact":
                        page.writeContact(masechet.getM(), perek.getName(),line.trim());
                        break;
                }
            }} catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(Arrays.toString(shas.getMasechets()));
    }


    public static String lineType(String line){
        if (line.isEmpty()){
            return "empty";
        }
        if (line.contains("מסכת") && line.contains("פרק א")){
            return "masechet";
        }if (line.contains("פרק ") && line.startsWith("מסכת ")){
            return "perek";
        }if (line.contains("דף ")){
            return "page";
        }else if (line.startsWith("גמרא")|| line.startsWith("משנה")){
            return "contact";
        }
        return "";

    }

}
