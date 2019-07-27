
package com.apps.aplikasiresepmasakan.model;

import java.util.HashMap;
import java.util.Map;

public class ResultResep {

    private String id_masakan;
    private String nama_masakan;
    private String resep_masakan;
    private String cara_masak;
    private String gambar_masakan;
    private String jenis_makanan;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId_masakan() {
        return id_masakan;
    }

    public void setId_masakan(String id_masakan) {
        this.id_masakan = id_masakan;
    }

    public String getNama_masakan() {
        return nama_masakan;
    }

    public void setNama_masakan(String nama_masakan) {
        this.nama_masakan = nama_masakan;
    }

    public String getResep_masakan() {
        return resep_masakan;
    }

    public void setResep_masakan(String resep_masakan) {
        this.resep_masakan = resep_masakan;
    }

    public String getCara_masak() {
        return cara_masak;
    }

    public void setCara_masak(String cara_masak) {
        this.cara_masak = cara_masak;
    }

    public String getGambar_masakan() {
        return gambar_masakan;
    }

    public void setGambar_masakan(String gambar_masakan) {
        this.gambar_masakan = gambar_masakan;
    }

    public String getJenis_makanan() {
        return jenis_makanan;
    }

    public void setJenis_makanan(String jenis_makanan) {
        this.jenis_makanan = jenis_makanan;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
