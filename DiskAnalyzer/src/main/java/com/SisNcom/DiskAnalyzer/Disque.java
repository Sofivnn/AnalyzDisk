package com.SisNcom.DiskAnalyzer;

import java.io.File;
import java.time.ZonedDateTime;

public class Disque {

    private File name;
    private ZonedDateTime dateAnalyze;
    private long EspaceTotale;
    private long EspaceLibre;
    private long EspaceUsed;

    public Disque(File name, ZonedDateTime dateAnalyze, long espaceTotale, long espaceLibre, long espaceUsed) {
        this.name = name;
        this.dateAnalyze = dateAnalyze;
        this.EspaceTotale = espaceTotale;
        this.EspaceLibre = espaceLibre;
        this.EspaceUsed = espaceUsed;
    }

    public File getName() {
        return name;
    }

    public void setName(File name) {
        this.name = name;
    }

    public ZonedDateTime getDateAnalyze() {
        return dateAnalyze;
    }

    public void setDateAnalyze(ZonedDateTime dateAnalyze) {
        this.dateAnalyze = dateAnalyze;
    }

    public long getEspaceTotale() {
        return EspaceTotale/(1024*1024*1024);
    }

    public void setEspaceTotale(long espaceTotale) {
        EspaceTotale = espaceTotale;
    }

    public long getEspaceLibre() {
        return EspaceLibre/(1024*1024*1024);
    }

    public void setEspaceLibre(long espaceLibre) {
        EspaceLibre = espaceLibre;
    }

    public long getEspaceUsed() {long EspaceUsed = getEspaceTotale() - getEspaceLibre(); return EspaceUsed;}

    public void setEspaceUsed(long espaceUsed) {
        EspaceUsed = espaceUsed;
    }

    @Override
    public String toString() {
        return "Disque {" +
                "name = " + getName() +
                ", dateAnalyze = '" + getDateAnalyze() + '\'' +
                ", EspaceTotale = " + getEspaceTotale() + " Go" +
                ", EspaceLibre = " + getEspaceLibre() + " Go" +
                ", EspaceUtilisé = " + getEspaceUsed() + " Go " +
                '}';
    }
}
