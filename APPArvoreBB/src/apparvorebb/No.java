package apparvorebb;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 * @date 21/05/2018
 */
public class No {
    private int dado;
    private No dir, esq;
    
    public No(int dado){
        this.dado = dado;
        dir = esq = null;
    }
    
    public int getDado(){
        return dado;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }
    
    
}
