
package appdicionario;

/**
 * Subclasse de TermoAbstrato, classe concreta que implementa ela.
 * @author felipe
 */
public class Termo extends TermoAbstrato{
    
    private String significado;
    
    public Termo(){
        super();
        significado = "";
    }
    
    public Termo(String palavra, String traducao){
        super(palavra, traducao);
        significado = "";
    }
    
    public Termo(String palavra, String traducao, String significado){
        super(palavra, traducao);
        this.significado = significado;
    }

    /**
     * @return o significado
     */
    public String getSignificado() {
        return significado;
    }

    /**
     * @param significado define o significado
     */
    public void setSignificado(String significado) {
        this.significado = significado;
    }
    
    @Override
    public String toString() {
        return String.format("%s#%s", getPalavra(), getTraducao());
    }

    @Override
    public boolean comparar(String palavra) {
        return palavra.equals(getPalavra());
    }
    
    
}
