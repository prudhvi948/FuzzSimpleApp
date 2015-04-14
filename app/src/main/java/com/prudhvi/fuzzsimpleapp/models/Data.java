package com.prudhvi.fuzzsimpleapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by prudhvi on 4/6/2015.
 */
public class Data {
    private String id;
    private String type;
    private String date;
    private String data;

    public Data() {

    }

    public Data(JSONObject jsonObject) {
        if(jsonObject != null) {
            try {
                id = jsonObject.getString("id");
                type = jsonObject.getString("type");
                if(jsonObject.has("date")) {
                    date = jsonObject.getString("date");
                }
                if(jsonObject.has("data")) {
                    data = jsonObject.getString("data");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        if(date == null) {
            return "";
        }
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
