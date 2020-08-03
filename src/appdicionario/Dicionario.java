package appdicionario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Classe do dicionario que abriga todos os termos
 * @author felipe
 */
public class Dicionario {
    
    private final ArrayList<TermoAbstrato> termos;
    
    public Dicionario(){
        termos = new ArrayList<>();
    }
    /**
     * Adiciona um termo do tipo da superclass para a lista
     * @param termo a adicionar
     */
    public void inserir(TermoAbstrato termo){
        termos.add(termo);
    }
    
    /**
     * Exclui um termo do tipo da superclasse para a lista
     * @param termo 
     */
    public void excluir(TermoAbstrato termo){
        termos.remove(termo);
    }
    
    /**
     * Traduz um palavra
     * @param palavra para pesquisar no campo palavra do TermoAbstrato
     * @return um TermoAbstrato que contem a traducao da palavra
     */
    public TermoAbstrato traduzir(String palavra){
        palavra = palavra.toLowerCase();
        for (TermoAbstrato t : termos) {
            if(t.comparar(palavra) && !palavra.equals(""))
                return t;
        }
        return new Termo();
    }
    
    /**
     * Retorna um TermoAbstrato que contem a palavra a pesquisar
     * @param palavra para pesquisar nos dois campos do TermoAbstrato
     * @return um TermoAbstrato com a pesquisa feita, ou null
     */
    public TermoAbstrato pesquisar(String palavra){
        for(TermoAbstrato t: termos){
            if(palavra.equals(t.getPalavra()) || palavra.equals(t.getTraducao()))
                return t;
        }
        return new Termo();
    }
    
    /**
     * Traduz uma frase 
     * @param frase que queremos traduzir
     * @return uma string com as palavras que se conseguiu traduzir
     */
    public String traduzirSentenca(String frase){
        frase = frase.toLowerCase();
        String[] palavras = frase.split(" ");
        String ret = "";
        TermoAbstrato aux;
        for (String palavra : palavras){
            aux = traduzir(palavra.trim());
            if(!aux.getTraducao().equals("")) ret += aux.getTraducao() + " ";
            else ret += palavra + " ";
        }
        return ret;
    }
    
    /**
     * Pega o total de termos que ha no dicionario
     * @return numero representando a quantidade de termos do dicionario
     */
    public int getTotalTermos(){
        return termos.size();
    }
    
    /**
     * Grava um dicionario em um arquivo txt
     * @return true se a operacao foi concluida com sucesso, false senao
     */
    public boolean gravar(){
        try{
            File arquivo = new File("dicionario.txt"); //se já existir, será sobreescrito  
            FileWriter fw = new FileWriter(arquivo);  
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(TermoAbstrato t : termos){
                bw.write(t.toString() + "\n");
            }   
            bw.flush();
            bw.close();       
        }catch(IOException e){
            System.out.println(e.toString());
            return false;
        }
        return true;
    }
    
    /**
     * Carrega um dicionario de um arquivo txt
     * @return true se a operacao foi concluida com sucesso, false senao
     */
    public boolean carregar(){
        String read;
        String[] args;
        String sinonimos[] = null;
        try{
            RandomAccessFile file = new RandomAccessFile("lista_palavras.txt", "rw");
            read = file.readLine();
            while(file.getFilePointer() < file.length()){
                read = file.readLine();
                args = read.split("#");
                if (args[0].contains(",")){
                    sinonimos = args[0].split(",");
                    TermoCompleto t = new TermoCompleto(sinonimos[0], args[1], "", args[2]);
                    inserir(t);
                    for(int i = 1; i < sinonimos.length; i++){
                        t.addSinonimo(sinonimos[i]);
                    }
                }
                if(args.length == 2)
                    inserir(new Termo(args[1], args[0]));
            }
            file.close();
        }catch(IOException e){
            System.out.println(e.toString());
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return termos.toString();
    }
    
    
}
