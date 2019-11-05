package com.example.buylist;

public class Item {

    private String nomeItem;
    private Integer quantidade;
    private Integer prioridade;

    public String getNomeItem() {
        return nomeItem;
    }



    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
