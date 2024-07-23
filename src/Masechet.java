import java.io.File;
import java.util.Arrays;

public class Masechet {
    private String m;
    private Perek[] pereks = new Perek[0];

    public Perek[] getPereks() {
        return pereks;
    }

    public void setPereks(Perek pereks) {
        Perek[] pereks1 = new Perek[getPereks().length+1];
        int i;
        for (i = 0; i < getPereks().length; i++) {
            pereks1[i] = getPereks()[i];
        }
        pereks1[i] = pereks;
        this.pereks = pereks1;
    }

    @Override
    public String toString() {
        return "Masechet{" +
                "m='" + m + '\'' +
                ", pereks=" + Arrays.toString(pereks) +
                '}';
    }

    public Masechet(String m) {
        this.m = m;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
    public static String nameOfMasechet(String line){
        String[] str = line.split(" ");
        String name = "";
        for (int i = 0; i < str.length; i++) {
            if(str[i].equals("פרק")){
                return name;
            }
            name += str[i] + " ";
        }
        return name;
    }
}
