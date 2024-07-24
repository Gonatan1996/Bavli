import java.io.File;
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
                        page.writeContent(masechet.getM(), perek.getName(),line.trim());
                        break;
                }
            }
            search(shas);
        } catch (Exception e) {
            System.out.println(e);
        }




    }public static void search(Shas shas) {
        Scanner scan = new Scanner(System.in);
        String m,pag;
        System.out.println("enter m");
        m = scan.nextLine();
        System.out.println("enter page");
        pag = scan.nextLine();
        for (int i = 0; i < shas.getMasechets().length; i++) {
          //  System.out.println(shas.getMasechets()[i].getM());
            if (m.equals(shas.getMasechets()[i].getM())){
                for (int j = 0; j < shas.getMasechets()[i].getPereks().length; j++) {
                    for (int k = 0; k < shas.getMasechets()[i].getPereks()[j].getPages().length; k++) {
                        //System.out.println(shas.getMasechets()[i].getPereks()[j].getPages()[k].getName());
                        if (pag.equals(shas.getMasechets()[i].getPereks()[j].getPages()[k].getName())){
                            try {
                                System.out.println(shas.getMasechets()[i].getPereks()[j].getPages()[k].getName());
                                Scanner scanner = new Scanner(new File(shas.getMasechets()[i].getPereks()[j].getPages()[k].getName()));
                                String line = scanner.nextLine();
                                while (scanner.hasNextLine()){
                                    System.out.println(line);
                                }return;
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    }

                }
                System.out.println("דף לא נמצא");
            }

        }
        System.out.println("מסכת לא נמצאה");


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
