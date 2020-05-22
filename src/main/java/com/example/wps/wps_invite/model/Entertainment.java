package com.example.wps.wps_invite.model;

public class Entertainment {
    private int wps_id;
    private String wps_sid;

    public int getWps_id() {
        return wps_id;
    }

    public void setWps_id(int wps_id) {
        this.wps_id = wps_id;
    }

    public String getWps_sid() {
        return wps_sid;
    }

    public void setWps_sid(String wps_sid) {
        this.wps_sid = wps_sid;
    }

    @Override
    public String toString() {
        return "Entertainment{" +
                "wps_id=" + wps_id +
                ", wps_sid='" + wps_sid + '\'' +
                '}';
    }
}
