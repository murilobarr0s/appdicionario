
package appdicionario;

/**
 * Super classe abstrata dos termos de um dicionario
 * @author felipe
 */
public abstract class TermoAbstrato {
    
    private String palavra;
    private String traducao;

    public TermoAbstrato() {
        palavra = "";
        traducao = "";
    }
    
    public TermoAbstrato(String palavra, String traducao) {
        this.palavra = palavra;
        this.traducao = traducao;
    }
    

    /**
     * @return a palavra
     */
    public String getPalavra() {
        return palavra;
    }

    /**
     * @param palavra a palavra a definir
     */
    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    /**
     * @return a traducao
     */
    public String getTraducao() {
        return traducao;
    }

    /**
     * @param traducao a traducao a definir
     */
    public void setTraducao(String traducao) {
        this.traducao = traducao;
    }
    
    @Override
    public abstract String toString();
    
    /**
     * Compara para saber se eh a mesma palavra
     * @param palavra a comparar
     * @return true se for igual,senao false
     */
    public abstract boolean comparar(String palavra);
    
}
