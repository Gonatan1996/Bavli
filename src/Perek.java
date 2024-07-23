import java.util.Arrays;

public class Perek {

    private String name ;
    private Page[] pages = new Page[0];

    public void setName(String name) {
        this.name = name;
    }

    public Page[] getPages() {
        return pages;
    }

    public void setPages(Page pages) {
        Page[] pages1 = new Page[getPages().length+1];
        int i;
        for (i = 0; i < getPages().length; i++) {
            pages1[i] = getPages()[i];
        }
        pages1[i] = pages;
        this.pages = pages1;
    }

    @Override
    public String toString() {
        return "Perek{" +
                "name='" + name + '\'' +
                ", pages=" + Arrays.toString(pages) +
                '}';
    }

    public String getName() {
        return name;
    }

    public Perek(String name) {
        this.name = name;
    }
    public static String nameOfPerek(String line){
        String name = "";
        String[] str = line.trim().split(" ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("פרק")){
                for (int j = i; j < str.length; j++) {
                    name += str[j] + " ";
                }
            }
        }
        return name;
    }
}
