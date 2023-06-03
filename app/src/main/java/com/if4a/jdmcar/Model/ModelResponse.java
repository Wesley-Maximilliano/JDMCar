package com.if4a.jdmcar.Model;

import java.util.List;

public class ModelResponse {
    private String kode, pesan;

    private List<ModelJDM> data;

    public String getKode() {
        return kode;
    }

    public String getPesan() {
        return pesan;
    }

    public List<ModelJDM> getData() {
        return data;
    }
}
