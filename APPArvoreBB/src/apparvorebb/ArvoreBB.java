package apparvorebb;

import java.util.Stack;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 * @date 21/05/2018
 */
public class ArvoreBB {

    private No raiz;

    public ArvoreBB() {
        raiz = null;
    }

    public boolean insere(int dado) {
        No novo = new No(dado);
        if (raiz == null) {
            raiz = novo;
            return true;
        }
        No atual = raiz;
        No pai;
        while (true) {
            if (atual.getDado() == dado) {
                return false;
            }
            pai = atual;
            if (pai.getDado() > dado) {
                atual = atual.getEsq();
                if (atual == null) {
                    pai.setEsq(novo);
                    return true;
                }
            } else {
                atual = atual.getDir();
                if (atual == null) {
                    pai.setDir(novo);
                    return true;
                }
            }
        }
    }

    public void preOrdem() {
        if (raiz == null) {
            return;
        }

        Stack pilha = new Stack();

        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = (No) pilha.pop();
            System.out.print(atual.getDado() + " ");
            if (atual.getDir() != null) {
                pilha.push(atual.getDir());
            }
            if (atual.getEsq() != null) {
                pilha.push(atual.getEsq());
            }
        }
        System.out.println("");
    }

    public void EmOrdem() {
        if (raiz == null) {
            return;
        }

        Stack pilha = new Stack();

        No atual = raiz;

        while (!pilha.isEmpty() || atual != null) {
            if (atual != null) {
                pilha.push(atual);
                atual = atual.getEsq();
            } else {
                No no = (No) pilha.pop();
                System.out.print(no.getDado() + "");
                atual = no.getDir();
            }
        }
        System.out.println("");
    }

    public void EmOrdem2() {
        if (raiz == null) {
            return;
        }

        Stack pilha = new Stack();

        No atual = raiz;

        while (atual != null) { //percore todos os nós à esquerda até a folha
            pilha.push(atual);
            atual = atual.getEsq();
        }

        while (!pilha.isEmpty()) {
            atual = (No) pilha.pop();
            System.out.print(atual.getDado() + " ");

            if (atual.getDir() != null) {   //se tiver um nó à direita 
                atual = atual.getDir(); //vai para a direita

                while (atual != null) { //percorre todos os nós à esquerda até a folha 
                    pilha.push(atual);
                    atual = atual.getEsq();
                }
            }
        }
        System.out.println("");
    }

    public void posOrdem() {

        Stack pilha1 = new Stack();
        Stack pilha2 = new Stack();

        if (raiz == null) {
            return;
        }

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            // Tira da pilha 1 e coloca na pilha 2
            No atual = (No) pilha1.pop();
            pilha2.push(atual);

            // empilha os filhos esquerdo e direito na pilha 1
            if (atual.getEsq() != null) {
                pilha1.push(atual.getEsq());
            }
            if (atual.getDir() != null) {
                pilha1.push(atual.getDir());
            }
        }

        while (!pilha2.isEmpty()) {
            No temp = (No) pilha2.pop();
            System.out.print(temp.getDado() + " ");
        }
    }

    /* 
    / Exibe os elementos da árvore utilizando pilhas como auxiliar
    / Considera que os elementos tem 2 dígitos no máximo
     */
    public void exibeArvore() {
        Stack pilhaGlobal = new Stack();
        pilhaGlobal.push(raiz);
        int nEspacos = 32;
        boolean linhaEstaVazia = false;

        System.out.println(
                "......................................................");
        while (!linhaEstaVazia) {
            Stack pilhaInterna = new Stack();
            linhaEstaVazia = true;

            for (int j = 0; j < nEspacos; j++) {
                System.out.print(' ');
            }

            while (!pilhaGlobal.isEmpty()) {
                No atual = (No) pilhaGlobal.pop();
                if (atual != null) {
                    System.out.print(atual.getDado());
                    pilhaInterna.push(atual.getEsq());
                    pilhaInterna.push(atual.getDir());

                    if (atual.getEsq() != null || atual.getDir() != null) {
                        linhaEstaVazia = false;
                    }
                } else {
                    System.out.print("--");
                    pilhaInterna.push(null);
                    pilhaInterna.push(null);
                }
                for (int j = 0; j < nEspacos * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }  // end while !pilhaGlobal.isEmpty
            System.out.println();
            nEspacos /= 2;
            while (!pilhaInterna.isEmpty()) {
                pilhaGlobal.push(pilhaInterna.pop());
            }
        }  // end while !linhaEstaVazia 
        System.out.println(
                "......................................................");
    }  // end exibeArvore()

}
