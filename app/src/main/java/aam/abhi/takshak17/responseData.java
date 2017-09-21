package aam.abhi.takshak17;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 9/21/2017.
 */

public class responseData {
    private int status;
    private String statusMessage;
    ArrayList<Data> data;
    public int getStatus(){
        return this.status;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public String getstatusMessage(){
        return this.statusMessage;
    }
    public void setstatusMessage(String statusMessage){
        this.statusMessage = statusMessage;
    }
    public ArrayList<Data> getData(){
        return this.data;
    }
    public void setData(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Data.class);
        this.data = mapper.readValue(data, type);
    }
}
