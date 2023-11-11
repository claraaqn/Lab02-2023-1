package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar{

    private int[] array;
    private int indice_fim;

    public ListaArray() {

    }

    @Override
    public boolean buscaElemento(int valor) {
        if (this.array != null) {
            for(int i = 0; i < this.array.length; i++){
                if(this.array[i] == valor) {
                    return true;
                }
            }   
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        return this.array[valor];
    }

    @Override
    public int minimo() {
        int menor = this.array[0]; // considera a maior valor como o primeiro
        for(int i = 0; i <= this.array.length -1; i++){
            if(menor > this.array[i]){ // se o próximo valor for maior que o anterior ele é substituido 
                menor = this.array[i];
            }
        }
        return menor;
    }

    @Override
    public int maximo() {
        int maior = this.array[0]; // considera a maior valor como o primeiro
        for(int i = 0; i <= this.array.length -1; i++){
            if(maior < this.array[i]){ // se o próximo valor for maior que o anterior ele é substituido 
                maior = this.array[i];
            }
        }
        return maior;
    }

    @Override
    public int predecessor(int valor) {
        if (this.array != null) {
            if (valor>0){
                return this.array[valor-1];
            }
        }
        return -1;
    }

    @Override
    public int sucessor(int valor) {
        if (this.array != null) {
            if (valor<this.array.length){
                return this.array[valor+1];
            }
        }
        return -1;
    }

    @Override
    public void insereElemento(int valor) {
        if (this.array != null){
            insereFim(valor); 
        } else {
           this.array = new int[1];;
            this.array[0] = valor; 
        }
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (this.array != null) {
            int[] n = new int[this.array.length + 1];
            for (int i = 0; i < buscaIndice; i++) {
                n[i] = this.array[i];
            }
            n[buscaIndice] = valor;
            for (int i = buscaIndice; i < this.array.length; i++) {
                n[i + 1] = this.array[i];
            }
            this.array = n;
        }
    }
    

    @Override
    public void insereInicio(int valor) {
        if (this.array != null){
            int[] n =  new int[this.array.length + 1];
            n[0] = valor;
            for (int i = 1; i < n.length; i++){
                n[i] = this.array[i-1];
            }
            this.array = n;
        } else {
            this.array = new int[1];
            this.array[0] = valor;
        }
    }

    @Override
    public void insereFim(int valor) {
        int[] n = this.array;
        if (n != null) {
            this.array = new int[array.length + 1];
            for (int i = 0; i < array.length -1; i++){
                this.array[i] = n[i];
            }
            this.array[array.length - 1] = valor;
        } else {
            this.array = new int[1];
            this.array[0] = valor;
        }
    }

    @Override
    public void remove(int valor) {
        if (this.array != null) {
            int fora = -1;
            for (int i = 0; i < this.array.length; i++) {
                if (this.array[i] == valor) {
                    fora = i;
                    break;
                }
            }
            if (fora != -1) {
                for (int i = fora; i < this.array.length - 1; i++) {
                    this.array[i] = this.array[i + 1];
                }
                this.array[this.array.length - 1] = 0;
            }
        }
    }

    @Override
    public void removeIndice(int indice) {
        if (this.array != null) {
            if (indice == 0) {
                removeInicio();
            } else {
                int fora = -1; 
            if (this.array.length >= indice){
                fora = indice;
            }
            if (fora != -1) {
                for (int i = fora; i < this.array.length - 1; i++) {
                    this.array[i] = this.array[i + 1];
                }
                this.array[this.array.length - 1] = 0;
            }
            }
        }
    }

    @Override
    public void removeInicio() {
        if (this.array != null) {
            int tamanho = this.array.length -1;
            int[] n = new int[tamanho];
            if (this.array.length != 1) {
                for (int i = 1; i < tamanho; i++){
                    n[i-1] = this.array[i];
                }
            this.array = n;    
            } else {
                this.array[0] = 0;
            }
        }
    }

    @Override
    public void removeFim() {
        if (this.array != null) {
            int tamanho = this.array.length-1;
            int[] n = new int[tamanho];
            for (int i = 0; i < tamanho; i++){
                n[i] = this.array[i];
            }
            this.array = n;    
        }
    }
    
}
