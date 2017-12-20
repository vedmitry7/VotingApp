package com.vedmitryapps.votingapp;


public class Room {

    private int pos;
    private int neg;
    private int total;
    private int reset;
    private String clients;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getNeg() {
        return neg;
    }

    public void setNeg(int neg) {
        this.neg = neg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getReset() {
        return reset;
    }

    public void setReset(int reset) {
        this.reset = reset;
    }

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }
}
