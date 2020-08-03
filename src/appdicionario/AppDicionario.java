
package appdicionario;

import java.util.ArrayList;


public class AppDicionario {

    public static void main(String[] args) {
        Dicionario dic = new Dicionario();
        dic.inserir(new Termo("futebol", "soccer", "religiao"));
        dic.inserir(new TermoCompleto("computador", "computer", "trabalho", "[kompiuter]"));
        dic.inserir(new Termo("mulher", "woman", "mulheres bonitas"));
        TermoCompleto t = new TermoCompleto("praia", "beach", "coisa boa", "[biatchi]");
        t.addSinonimo("nudismo");
        t.addSinonimo("bikinis");
        
        
        
        //dic.gravar();
        dic.carregar();
        
        System.out.println(dic.traduzirSentenca("futebol praia mulher"));
        //System.out.println(dic);
    }
    
    
}
