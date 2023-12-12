package arrays;

import java.util.Arrays;

public class Vetor {
    private String[] elementos;
    private int tamanhoVetor;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanhoVetor = 0;
    }

    public boolean add(String elemento) {
        aumentaCapacidade();
        
        if (this.tamanhoVetor < elementos.length) {
            elementos[tamanhoVetor] = elemento;
            this.tamanhoVetor++;
            return true;
        }
        return false;
    }

    public boolean add(int indice, String elemento) {
        if (!(indice > 0 && indice < tamanhoVetor)) {
            throw new IllegalArgumentException("Posição invalida");
        }

        aumentaCapacidade();

        for (int i = this.tamanhoVetor - 1; i >= indice; i--) {
            this.elementos[i + 1] = elementos[i];
        }

        this.elementos[indice] = elemento;
        this.tamanhoVetor++;
        return true;
    }

    public void aumentaCapacidade() {
        if (this.tamanhoVetor == this.elementos.length) {
            String[] novosElementos = new String[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                novosElementos[i] = this.elementos[i];
            }
            this.elementos = novosElementos;
        }
    }

    public String busca(int indice) {
        if (!(indice > 0 && indice < tamanhoVetor)) {
            throw new IllegalArgumentException("Posição invalida");
        }

        return this.elementos[indice];
    }

    public int busca(String elemento) {
        for (int index = 0; index < tamanhoVetor; index++) {
            if (elementos[index].equals(elemento)) {
                return index;
            }
        }
        return -1;
    }

    public int tamanho() {
        return this.tamanhoVetor;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("[");

        for (int i = 0; i < this.tamanhoVetor - 1; i++) {
            str.append(this.elementos[i]);
            str.append(", ");
        }

        if (this.tamanhoVetor > 0) {
            str.append(this.elementos[this.tamanhoVetor - 1]);
        }

        str.append("]");
        return str.toString();
    }

}
