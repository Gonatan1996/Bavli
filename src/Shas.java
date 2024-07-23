import java.util.Arrays;

public class Shas {

    private Masechet[] masechets = new Masechet[0];

    public Masechet[] getMasechets() {
        return masechets;
    }

    @Override
    public String toString() {
        return "Shas{" +
                "masechets=" + Arrays.toString(masechets) +
                '}';
    }

    public void setMasechets(Masechet masechets) {
        Masechet[] masechets1 = new Masechet[getMasechets().length +1];
        int i;
        for ( i = 0; i < getMasechets().length; i++) {
            masechets1[i] = getMasechets()[i];
        }
        masechets1[i] = masechets;
        this.masechets = masechets1;
    }

    public static void setFullPath(String fullPath) {
        Shas.fullPath = fullPath;
    }

    private static String fullPath = "C:\\Users\\gonat\\OneDrive\\שולחן העבודה\\‎⁨תלמוד בבלי טקסט⁩.txt";


    public static String getFullPath() {
        return fullPath;
    }
}
