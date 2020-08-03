package appdicionario;

import java.util.ArrayList;

/**
 * SubClasse de Termo, tem pronuncia da palavra e lista de sinonimos
 * @author felipe
 */
public class TermoCompleto extends Termo {
    
    private String pronuncia;
    private ArrayList<String> sinonimos;
    
    public TermoCompleto(){
        super();
        sinonimos = new ArrayList<>();
        pronuncia = "";
    }
    
    public TermoCompleto(String palavra, String traducao, String sinonimo, String pronuncia){
        super(palavra, traducao, pronuncia);
        sinonimos = new ArrayList<>();
        this.pronuncia = pronuncia;
    }

    public String getPronuncia() {
        return pronuncia;
    }

    public void setPronuncia(String pronuncia) {
        this.pronuncia = pronuncia;
    }
    
    public void addSinonimo(String sinonimo){
        this.sinonimos.add(sinonimo);
    }
    
    @Override
    public String toString() {
        String sin = "", pro = "";
        for(String s : sinonimos) sin += s + ",";
        if(!sin.equals(""))
            sin = getPalavra() + "," + sin.substring(0, sin.length() - 1);
        else
            sin = getPalavra();
        if (getPronuncia().equals("")) return String.format("%s#%s", sin, getTraducao());
        return String.format("%s#%s#%s", sin, getTraducao(), getPronuncia());
    }

    @Override
    public boolean comparar(String palavra) {
        if(palavra.equals(getPalavra())) return true;
        for(String s : sinonimos){
            if(s.equals(palavra)) return true;
        }
        return false;
    }
}
