import java.io.Serializable;

public class Person implements Serializable {

    private String navn;
    private int alder;

    public Person(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public String getNavn() {
        return navn;
    }

    public int getAlder() {
        return alder;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }
}
