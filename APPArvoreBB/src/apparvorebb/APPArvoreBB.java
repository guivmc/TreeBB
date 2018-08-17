package apparvorebb;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 * @date 21/05/2018
 */
public class APPArvoreBB {

    public static void main(String[] args) {
        ArvoreBB arvore = new ArvoreBB();
        
        arvore.insere(10);
        arvore.insere(5);
        arvore.insere(20);
        arvore.insere(7);
        arvore.insere(6);
        arvore.exibeArvore();
        System.out.println("Pré:");
        arvore.preOrdem();
        System.out.println("Em:");
        arvore.EmOrdem();
        System.out.println("Pós:");
        arvore.posOrdem();
    }

}
