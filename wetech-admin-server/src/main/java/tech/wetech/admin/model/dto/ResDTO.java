package tech.wetech.admin.model.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ResDTO {
    private Integer state;
    private String value;
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setValue(String value) { this.value = value; }
}
