package com.example.wps.wps_invite.entity;

/**
 * @auther chairc
 * @date 2021/4/28 13:29
 */
public class ClientCode {
    private int id;
    private String clientCode;
    private String client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
